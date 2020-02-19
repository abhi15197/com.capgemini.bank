package com.capgemini.bank.dao;

import java.util.Date;

public interface IAcoountsDao {

	public boolean verifyAccount(String acc_num);
	
	public Date getLastPassbookUpdateDate(String acc_num);
	
	public void setLastPassbookUpdateDate(String acc_num);
	
	public void updateBalance(String acc_num,double balance);
}
