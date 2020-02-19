package com.capgemini.bank.service;

import java.util.Date;
//interface to contain the methods of the passbookservice class
public interface IPassbookService {

	boolean verifyAccountService(String acc_num);
	
	void updatePassbook(String acc_num);
	
	void accountSummary(String acc_num,Date fromDate,Date toDate);
}
