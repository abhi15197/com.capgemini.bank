package com.capgemini.bank.bean;
import java.util.Date;

public class Transaction {
	private Date transacton_date;
	private String account_number;
	private String transaction_mode;
	private String transaction_type;
	private double amount;
	private double balance;
	
	public Transaction(Date transacton_date, String account_number, String transaction_mode, String transaction_type,
			double amount, double balance) {
		super();
		this.transacton_date = transacton_date;
		this.account_number = account_number;
		this.transaction_mode = transaction_mode;
		this.transaction_type = transaction_type;
		this.amount = amount;
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	public Date getTransacton_date() {
		return transacton_date;
	}
	public void setTransacton_date(Date transacton_date) {
		this.transacton_date = transacton_date;
	}
	public String getAccount_number() {
		return account_number;
	}
	
	public String getTransaction_mode() {
		return transaction_mode;
	}
	
	public String getTransaction_type() {
		return transaction_type;
	}
	
	public double getAmount() {
		return amount;
	}	
}
