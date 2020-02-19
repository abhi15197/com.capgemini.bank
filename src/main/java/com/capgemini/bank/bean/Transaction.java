package com.capgemini.bank.bean;
import java.util.Date;

public class Transaction {
	private Date transactonDate;
	private String accountnumber;
	private String transactionMode;
	private String transactionType;
	private double amount;
	private double balance;
	
	
	
	public Transaction(Date transactonDate, String accountnumber, String transactionMode, String transactionType,
			double amount, double balance) {
		super();
		this.transactonDate = transactonDate;
		this.accountnumber = accountnumber;
		this.transactionMode = transactionMode;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
	}
	public double getBalance() {
		return balance;
	}
	
	public Date getTransactonDate() {
		return transactonDate;
	}	
	public String getAccountnumber() {
		return accountnumber;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public String getTransactionType() {
		return transactionType;
	}
	
	public double getAmount() {
		return amount;
	}	
}
