package com.capgemini.bank.dao;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import com.capgemini.bank.bean.Transaction;

public interface ITransactionDao {
	
	public void updatePassbook(String acc_num, Date last_update_date);
	
	public TreeMap<String, Transaction> forSortedMap(Map<String,Transaction> map);
	
	public void accountSummary(String acc_num, Date fromDate, Date toDate);
	
	public void updateBalance(String acc_num);
}
