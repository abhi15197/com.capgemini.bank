package com.capgemini.bank.dao;

import java.util.Date;

public interface IAcoountsDao {

	public boolean verifyAccount(String accountnumber);
	
	public Date getLastPassbookUpdateDate(String accountnumber);
	
	public void setLastPassbookUpdateDate(String accountnumber);
	
	public void updateBalance(String accountnumber,double balance);
}
