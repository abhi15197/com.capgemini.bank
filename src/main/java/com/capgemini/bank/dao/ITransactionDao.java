package com.capgemini.bank.dao;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import com.capgemini.bank.bean.Transaction;

public interface ITransactionDao {
	
	public void updatePassbook(String accountnumber, Date lastUpdateDate);
	
	public TreeMap<String, Transaction> forSortedMap(Map<String,Transaction> map);
	
	public void accountSummary(String accountnumber, Date fromDate, Date toDate);
	
	public void updateBalance(String accountnumber);
}
