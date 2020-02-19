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
	public boolean verifyAccount(String acc_num) {
		
		if(account.containsKey(acc_num))
		{
			
			return true;
		}
		else
			return false;
		
	}
	
	
	
	//method to get the last passbook update date
	//this method returns the date when the passbook last updated
	public Date getLastPassbookUpdateDate(String acc_num)
	{	
		return account.get(acc_num).getLast_passbook_update_date();
		
	}
	
	
	//method to set the last update date to the present day after the passbook is updated
	public void setLastPassbookUpdateDate(String acc_num)
	{	
		account.get(acc_num).setLast_passbook_update_date(new Date());
		
	}
	
	
	
	//method to update the balance in the collection 
	public void updateBalance(String acc_num,double balance)
	{
		account.get(acc_num).setBalance(balance);
	}

}
