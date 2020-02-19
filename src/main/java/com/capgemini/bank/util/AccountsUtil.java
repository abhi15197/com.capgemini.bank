package com.capgemini.bank.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.capgemini.bank.bean.Account;

public class AccountsUtil {
	private AccountsUtil()
	{
		
	}
	private static Map<String,Account> accounts=new ConcurrentHashMap<String, Account>();
	//predefined data in the collection of account to work on during the project
	//this is a static data used by all the objects of bean class and onther methods
	//this data contains all the details of the user account which are needed during the project 
	static
	{	SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");//->date format to get the required date from the string
		try {
			accounts.put("300080705001", new Account("300080705001","Kuldeep","Yadav",25000.00,format.parse("15-02-2018")));
			accounts.put("300080705002", new Account("300080705002","Shikhar","Dhawan",25000.00,format.parse("15-02-2015")));
			accounts.put("300080705003", new Account("300080705003","M.S","Dhoni",25000.00,format.parse("15-01-2017")));
			accounts.put("300080705004", new Account("300080705004","Virat","Kohli",25000.00,format.parse("15-02-2017")));
			accounts.put("300080705005", new Account("300080705005","Rohit","Sharma",25000.00,format.parse("18-02-2017")));
			accounts.put("300080705006", new Account("300080705006","KL","Rahul",25000.00,format.parse("15-03-2017")));
			accounts.put("300080705007", new Account("300080705007","Manoj","Tiwari",25000.00,format.parse("15-05-2017")));
			accounts.put("300080705008", new Account("300080705008","Jaspreet","Bumrah",25000.00,format.parse("22-02-2017")));
		
		} catch (ParseException e) {
			//catch block to catch the exceptions during the parse of the date in the specific format
			e.printStackTrace();
		}	
	}
	
	//method to return the collection where ever required
	public static Map<String, Account> getAccount()
	{
		return accounts;
		
	}
}
