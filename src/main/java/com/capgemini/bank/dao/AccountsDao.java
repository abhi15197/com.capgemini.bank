package com.capgemini.bank.dao;

import java.util.Date;
import java.util.Map;
import com.capgemini.bank.bean.Account;
import com.capgemini.bank.util.AccountsUtil;

public class AccountsDao implements IAcoountsDao{
	Map<String,Account> account=AccountsUtil.getAccount();
	//gets the account collection from the util class
	
	//method to verify the account if it exists or not in the collection
	//returns true if present else returns false
	public boolean verifyAccount(String accountnumber) {
		
		return account.containsKey(accountnumber);
		
	}
	
	
	
	//method to get the last passbook update date
	//this method returns the date when the passbook last updated
	public Date getLastPassbookUpdateDate(String accountnumber)
	{	
		return account.get(accountnumber).getLastPassbookUpdateDate();
		
	}
	
	
	//method to set the last update date to the present day after the passbook is updated
	public void setLastPassbookUpdateDate(String accountnumber)
	{	
		account.get(accountnumber).setLastPassbookUpdateDate(new Date());
		
	}
	
	
	
	//method to update the balance in the collection 
	public void updateBalance(String accountnumber,double balance)
	{
		account.get(accountnumber).setBalance(balance);
	}
	
	public boolean getAccountDetails(String accountnumber)
	{
		System.out.println("NAME OF ACCOUNT HOLDER:"+account.get(accountnumber).getFirstName()+
				" "+account.get(accountnumber).getLastName());
		System.out.println("ACCOUNT NUMBER:"+account.get(accountnumber).getAccountNumber());
		System.out.println("BALANCE:"+account.get(accountnumber).getBalance());
		System.out.println("=================================================================================");
		System.out.println("=================================================================================");
		
		return true;
		
	}

}
