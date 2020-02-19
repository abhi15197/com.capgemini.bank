package com.capgemini.bank.bean;

import java.util.Date;

public class Account {
	private String account_number;
	private String first_name;
	private String last_name;
	private double balance;
	
	private Date last_passbook_update_date ;
	
	public Account(String account_number, String first_name, String last_name, double balance,
				Date last_passbook_update_date) {
		super();
		this.account_number = account_number;
		this.first_name = first_name;
		this.last_name = last_name;
		this.balance = balance;
		this.last_passbook_update_date = last_passbook_update_date;
	}
	public String getAccount_number() {
		return account_number;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getLast_passbook_update_date() {
		return last_passbook_update_date;
	}
	public void setLast_passbook_update_date(Date last_passbook_update_date) {
		this.last_passbook_update_date = last_passbook_update_date;
	}
	

	

}
