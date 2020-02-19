package com.capgemini.bank.bean;

import java.util.Date;

public class Account {
	private String accountnumber;
	private String firstname;
	private String lastname;
	private double balance;
	
	private Date lastPassbookUpdateDate ;
	
	public Account(String accountnumber, String firstname, String lastname, double balance,
				Date lastPassbookUpdateDate) {
		super();
		this.accountnumber = accountnumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.balance = balance;
		this.lastPassbookUpdateDate = lastPassbookUpdateDate;
	}
	public String getAccountNumber() {
		return accountnumber;
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getLastPassbookUpdateDate() {
		return lastPassbookUpdateDate;
	}
	public void setLastPassbookUpdateDate(Date lastPassbookUpdateDate) {
		this.lastPassbookUpdateDate = lastPassbookUpdateDate;
	}
	

	

}
