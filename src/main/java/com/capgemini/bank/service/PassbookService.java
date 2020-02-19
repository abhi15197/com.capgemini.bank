package com.capgemini.bank.service;

import java.util.Date;

import com.capgemini.bank.dao.AccountsDao;
import com.capgemini.bank.dao.TransactionDao;

public class PassbookService implements IPassbookService{
	
	AccountsDao account=new AccountsDao();
	TransactionDao transaction=new TransactionDao();
	
	
	//method to call the  update passbook in dao
	@Override
	public void updatePassbook(String acc_num) 
	{	
			Date last_update_date=account.getLastPassbookUpdateDate(acc_num);
			transaction.updatePassbook(acc_num,last_update_date);
	}
	
	
	//method to verify the account entered  is present in the collection
	//this will call the method verifyAccount in dao
	@Override
	public boolean verifyAccountService(String acc_num)
	{
		if(account.verifyAccount(acc_num))
		{	
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	//method to call the dao method to print the account summary
	@Override
	public void accountSummary(String acc_num, Date fromDate, Date toDate) 
	{
		transaction.accountSummary(acc_num, fromDate, toDate);
	}
	  

}
