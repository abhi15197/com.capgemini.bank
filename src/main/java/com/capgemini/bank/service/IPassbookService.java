package com.capgemini.bank.service;

import java.util.Date;
//interface to contain the methods of the passbookservice class
public interface IPassbookService {

	boolean verifyAccountService(String accountnumber);
	
	void updatePassbook(String accountnumber);
	
	void accountSummary(String accountnumber,Date fromDate,Date toDate);
}
