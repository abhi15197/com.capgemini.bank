package com.capgemini.bank.service;

import java.util.Date;

import com.capgemini.bank.dao.AccountsDao;
import com.capgemini.bank.dao.TransactionDao;

public class PassbookService implements IPassbookService{
	
	AccountsDao account=new AccountsDao();
	TransactionDao transaction=new TransactionDao();
	
	
	//method to call the  update passbook in dao
	@Override
	public void updatePassbook(String accountnumber) 
	{	
			Date lastUpdateDate=account.getLastPassbookUpdateDate(accountnumber);
			transaction.updatePassbook(accountnumber,lastUpdateDate);
	}
	
	
	//method to verify the account entered  is present in the collection
	//this will call the method verifyAccount in dao
	@Override
	public boolean verifyAccountService(String accountnumber)
	{
		return account.verifyAccount(accountnumber);
		
	}
	
	
	
	//method to call the dao method to print the account summary
	@Override
	public void accountSummary(String accountnumber, Date fromDate, Date toDate) 
	{
		transaction.accountSummary(accountnumber, fromDate, toDate);
	}
	  

}
