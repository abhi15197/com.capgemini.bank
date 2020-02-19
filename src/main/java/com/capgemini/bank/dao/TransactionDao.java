package com.capgemini.bank.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.capgemini.bank.bean.Transaction;
import com.capgemini.bank.util.TransactionUtil;



/**
 * 
 * @author mishra
 *
 *
 *this is a DAO class to the Transaction Bean class {@link Transaction} 
 *in this class we can access values in the bean class objects which are present in the collection
 *util class of {@link TransactionUtil} as a MAP in the collection
 *  
 *
 *here both methods/functions update and summary ARE operated 
 *also two more methods are present 1 {@link TransactionDao.forSortedMap}-> to sort the map in desired pattern
 *2 {@link TransactionDao.printpassbook}-> to print the passbook 
 *
 */

public class TransactionDao {
	Map<String,Transaction> transaction=TransactionUtil.getTransaction();
	//gets the transaction collection from the util class
	
	AccountsDao acc=new AccountsDao();
	//objec of accountdao is created to access its method
 	
	SimpleDateFormat date=new SimpleDateFormat("dd-MM-yyyy");
	//format the date within the required format
	
	
	
	//updates the passbook from when it is nit updated
	public void updatePassbook(String accountnumber, Date lastUpdateDate)
	{
		Map<String,Transaction> newData = transaction.entrySet().stream()
	                .filter(map -> map.getValue().getAccountnumber().equals(accountnumber))
	                		.filter(map->map.getValue().getTransactonDate().after(lastUpdateDate))
	                					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		//stream to filter the required map transaction from the full collection
			acc.setLastPassbookUpdateDate(accountnumber);
			//sets the last passbook update date in account collection
			printPassbook(forSortedMap(newData));
			//print the passbook page
			double balance= updateBalance(accountnumber);
			System.out.println("Ledger Balance: "+balance);
			//updates the balance
	}
	
	
	
	//method to sort the map in required format
	public TreeMap<String, Transaction> forSortedMap(Map<String,Transaction> map)
	{	
		TreeMap<String, Transaction> newsortedmap=new TreeMap<String, Transaction>();
		
		for(Entry<String, Transaction> entry:map.entrySet())
		{
			newsortedmap.put(entry.getKey(), entry.getValue());
		}
		return newsortedmap;
		
	}
	
	
	
	
	
	//method to print passbook
	private void printPassbook(TreeMap<String, Transaction> data)
	{
		System.out.println("=================================================================================");
		System.out.println("PASSBOOK=====================================================================PAGE");
		System.out.println("===========================Account===============================================");
		System.out.println("DATE\t  \tDESCRIPTION\tWITHDRAWL/DEPOSIT\tAMOUNT\t\tBALANCE");
		
		for(Entry<String, Transaction> i:data.entrySet())
		{	
			System.out.format("%s\t%s  \t\t%s\t  \t%s\t\t%s%n",date.format(i.getValue()
					.getTransactonDate()),i.getValue().getTransactionMode(),
					i.getValue().getTransactionType(),i.getValue().getAmount(),
					i.getValue().getBalance());
		}
		
		System.out.println("=================================================================================");
		System.out.println("=================================================================================");
		
	}
	
	
	
	
	//method to print summary
	public boolean accountSummary(String accountnumber, Date fromDate, Date toDate)
	{
		ConcurrentMap<String, Transaction> newData=transaction.entrySet()
				.stream().filter(map->map.getValue().getAccountnumber().equals(accountnumber))
						.filter(map->map.getValue().getTransactonDate().after(fromDate)).filter(map->map.getValue().
								getTransactonDate().before(toDate)).collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		
		//stream to filter the required map transaction from the full collection
		printPassbook(forSortedMap(newData));
		//calls printPassbook method to print the details
		updateBalance(accountnumber);
		acc.getAccountDetails(accountnumber);
		//calls update balance method to update the balance in the account.
		return true;
		
	}
	
	
	
	
	
	
	
	
	
	
	//method to update balance in Account Collection
	public double updateBalance(String accountnumber)
	{String flag=null;
		Map<String ,Transaction> newmap=transaction.entrySet().stream().filter(map->map.getValue()
				.getAccountnumber().equals(accountnumber)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		//stream to filter the required map transaction from the full collection
		TreeMap<String,Transaction> sortedmap=forSortedMap(newmap);
	for (Entry<String, Transaction> entry : sortedmap.entrySet()) 
				flag=entry.getKey();
		
	
	
	double newbalance=transaction.get(flag).getBalance();
		acc.updateBalance(accountnumber, newbalance);
		return newbalance;
	}
	
}
