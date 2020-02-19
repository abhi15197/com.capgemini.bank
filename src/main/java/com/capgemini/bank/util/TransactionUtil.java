package com.capgemini.bank.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import com.capgemini.bank.bean.Transaction;

public class TransactionUtil {
	private TransactionUtil()
	{
		
	}
	private static LinkedHashMap<String,Transaction> transactions= new LinkedHashMap<String, Transaction>();
	static {
		//predefined data in the collection of account to work on during the project
		//this is a static data used by all the objects of bean class and onther methods
		//this data contains all the details of the user account which are needed during the project 
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");//->date format to get the required date from the string
		try {
			transactions.put("Tran0001", new Transaction(format.parse("15-02-2019"), "300080705005","by cash", "credit", 25000.00,25000.00));
			transactions.put("Tran0002", new Transaction(format.parse("15-03-2019"), "300080705008","by cash", "credit", 25000.00,25000.00));
			transactions.put("Tran0003", new Transaction(format.parse("15-04-2019"), "300080705004","by cash", "credit", 25000.00,25000.00));
			transactions.put("Tran0004", new Transaction(format.parse("15-05-2019"), "300080705003","by cash", "credit", 25000.00,25000.00));
			transactions.put("Tran0005", new Transaction(format.parse("15-06-2019"), "300080705001","by cash", "credit", 28000.00,25000.00));
			transactions.put("Tran0006", new Transaction(format.parse("15-07-2019"), "300080705002","by cash", "credit", 25000.00,25000.00));
			transactions.put("Tran0007", new Transaction(format.parse("15-08-2019"), "300080705006","by cash", "credit", 25000.00,25000.00));
			transactions.put("Tran0008", new Transaction(format.parse("15-09-2019"), "300080705007","by cash", "credit", 25000.00,25000.00));
			transactions.put("Tran0009", new Transaction(format.parse("15-10-2019"), "300080705002","by cash", "credit", 25000.00,25000.00));
			transactions.put("Tran0010", new Transaction(format.parse("18-11-2019"), "300080705008","by cash", "debit", 5000.00,20000.00));
			transactions.put("Tran0011", new Transaction(format.parse("17-12-2019"), "300080705001","by cash", "credit", 26000.00,51000.00));
			transactions.put("Tran0012", new Transaction(format.parse("01-01-2020"), "300080705007","by cash", "debit", 3000.00,22000.00));
			transactions.put("Tran0013", new Transaction(format.parse("13-01-2020"), "300080705005","by cash", "credit", 25000.00,50000.00));
			transactions.put("Tran0014", new Transaction(format.parse("19-01-2020"), "300080705006","by cash", "debit", 8000.00,17000.00));
			transactions.put("Tran0015", new Transaction(format.parse("22-01-2020"), "300080705003","by cash", "credit", 12000.00,37000.00));
			transactions.put("Tran0016", new Transaction(format.parse("23-01-2020"), "300080705008","by cash", "credit", 58000.00,78000.00));
			transactions.put("Tran0017", new Transaction(format.parse("28-01-2020"), "300080705004","by cash", "debit", 15000.00,10000.00));
			transactions.put("Tran0018", new Transaction(format.parse("05-02-2020"), "300080705003","by cash", "credit", 23000.00,60000.00));
			transactions.put("Tran0019", new Transaction(format.parse("08-02-2020"), "300080705004","by cash", "credit", 258000.00,268000.00));
			transactions.put("Tran0020", new Transaction(format.parse("09-02-2020"), "300080705001","by cash", "credit", 35000.00,86000.00));
			transactions.put("Tran0021", new Transaction(format.parse("12-02-2020"), "300080705008","by cash", "debit", 50000.00,28000.00));
			transactions.put("Tran0022", new Transaction(format.parse("13-02-2020"), "300080705002","by cash", "credit", 13000.00,38000.00));
			transactions.put("Tran0023", new Transaction(format.parse("15-02-2020"), "300080705007","by cash", "debit", 20000.00,2000.00));
			transactions.put("Tran0024", new Transaction(format.parse("15-02-2020"), "300080705005","by cash", "credit", 25000.00,75000.00));
			
		} catch (ParseException e) {
			//catch block to catch the exceptions during the parse of the date in the specific format
			e.printStackTrace();
		}
	}
	public static LinkedHashMap<String, Transaction> getTransaction()
	{
		return transactions;
		
	}
	

}