package com.capgemini.bank.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.capgemini.bank.bean.Transaction;
import com.capgemini.bank.util.TransactionUtil;

public class TransactionDao {
	Map<String,Transaction> transaction=TransactionUtil.getTransaction();
	//gets the transaction collection from the util class
	
	AccountsDao acc=new AccountsDao();
	//objec of accountdao is created to access its method
 	
	SimpleDateFormat date=new SimpleDateFormat("dd-mm-yyyy");
	//format the date within the required format
	
	
	
	//updates the passbook from when it is nit updated
	public void updatePassbook(String acc_num, Date last_update_date)
	{
		Map<String,Transaction> newData = transaction.entrySet().stream()
	                .filter(map -> map.getValue().getAccount_number().equals(acc_num))
	                		.filter(map->map.getValue().getTransacton_date().after(last_update_date))
	                					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		//stream to filter the required map transaction from the full collection
			acc.setLastPassbookUpdateDate(acc_num);
			//sets the last passbook update date in account collection
			printPassbook(forSortedMap(newData));
			//print the passbook page
			updateBalance(acc_num);
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
		System.out.println("=================================================================================");
		System.out.println("DATE\t  \tDESCRIPTION\tWITHDRAWL/DEPOSIT\tAMOUNT\t\tBALANCE");
		
		for(Entry<String, Transaction> i:data.entrySet())
		{	
			System.out.format("%s\t%s  \t\t%s\t  \t%s\t\t%s\n",date.format(i.getValue()
					.getTransacton_date()),i.getValue().getTransaction_mode(),
					i.getValue().getTransaction_type(),i.getValue().getAmount(),
					i.getValue().getBalance());
		}
		
		System.out.println("=================================================================================");
		System.out.println("=================================================================================");
		System.out.println("=================================================================================");
		
	}
	
	
	//method to print summary
	public void accountSummary(String acc_num, Date fromDate, Date toDate)
	{
		ConcurrentMap<String, Transaction> newData=transaction.entrySet()
				.stream().filter(map->map.getValue().getAccount_number().equals(acc_num))
						.filter(map->map.getValue().getTransacton_date().after(fromDate)).filter(map->map.getValue().
								getTransacton_date().before(toDate)).collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		//stream to filter the required map transaction from the full collection
		printPassbook(forSortedMap(newData));
		//calls printPassbook method to print the details
		updateBalance(acc_num);
		//calls update balance method to update the balance in the account.
	}
	
	
	
	
	Date dateflag=new Date();
	String flag="null";
	
	
	//method to update balance in Account Collection
	public void updateBalance(String acc_num)
	{
		Map<String ,Transaction> newmap=transaction.entrySet().stream().filter(map->map.getValue()
				.getAccount_number().equals(acc_num)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		//stream to filter the required map transaction from the full collection
	try {
		dateflag = date.parse("01-01-2000");
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
	for (Entry<String, Transaction> entry : newmap.entrySet()) {
	    if(dateflag.before(entry.getValue().getTransacton_date()))
	    {
	    	dateflag=entry.getValue().getTransacton_date();
	    	flag=entry.getKey();
	    }
	}
	double newbalance=transaction.get(flag).getBalance();
		acc.updateBalance(acc_num, newbalance);
		System.out.println("Ledger Balance::"+newbalance);
		System.out.println("=================================================================================");
		System.out.println("=================================================================================");
	}
	
}
