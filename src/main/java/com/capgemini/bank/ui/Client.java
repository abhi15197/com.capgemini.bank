package com.capgemini.bank.ui;

import java.util.Date;
import java.util.Scanner;

import com.capgemini.bank.exception.BankException;
import com.capgemini.bank.service.PassbookService;
import com.capgemini.bank.validator.Validate;


/**
 * 
 * @author mishra
 * 
 * Introducing the project->
 * this is the project module in which module need to handle the passbook management module
 * here there is two sub-module
 * 
 *  
 * 1->to update the passbook->In this submodule the program needs to update the passbook from where it was last printed
 * Here the user is asked for the account number and the program updates the passbook with the recent transaction.
 * 
 * 
 * 
 * 2->to show account summary->this submodule needs to print the account details or summary of the transaction 
 * which happened between a specific period of time.
 * Here the user is asked to enter the account number, fromDate, ToDate and the whole transaction placed 
 * between the period is displayed. 
 * 
 *
 */
public class Client {
	//scanner class object created to take input
	static Scanner sc=new Scanner(System.in);
	
	
	//Service class object created to communicate with the service and dao classes
	static PassbookService passbook=new PassbookService();
	public static void main(String[] args) throws BankException {
		
		Client object=new Client();
		object.print("welcome");
		boolean loopbreaker=false;
		
		while(true)   //loop to take valid input from user
		{
			try {
			object.print("options");
			String choice=sc.next();    //user input to ask for choices
			sc.nextLine();
				//validation of choice variable
			if(!Validate.validatePattern(choice, Validate.CHOICE_PATTERN))
				throw new BankException("INVALID CHOICE  ->ENTER A VALID NUMBER");
				
		
			else
			{
				switch(choice)
				//switch block to validate different entries
				{
				
				case "1":
				//calls the caseone method
					object.caseone();
					break;
				
				case "2":
				//calls the casetwo methods
					object.casetwo();
					break;
					
					
				//implements the exit stage of the program
				case "3":
				
					System.out.println("Thank You For Using The Passbook Management");
					System.out.println("--------------------------------------------");
					sc.close();
					loopbreaker=true;
					break;
					
				
				default:
					throw new BankException("INVALID CHOICE   --->>>ENTER A VALID CHOICE");	
					
				
				}
			}
			
			if(loopbreaker)
				break;
			
		}
			catch(BankException e)
			{
				e.getMessage();
			}
		}
		
	}
	
	
	//implements the passbook update funtion of the project
	private boolean caseone()
	{
		
		
			System.out.println("ENTER THE ACCOUNT NUMBER:");
			while(true) {
				
				try {
				String accountnumber=sc.next();
				sc.nextLine();
				
				if(Validate.validatePattern(accountnumber, Validate.ACCOUNT_NUMBER_PATTERN)==true)
				{	
					if(passbook.verifyAccountService(accountnumber)==false)
					{
						System.out.println("NO ACCOUNT ASSOCIATED TO THIS ACCOUNT NUMBER");
					}
					else
						passbook.updatePassbook(accountnumber);
					break;
				}
				else
				{
					throw new BankException("Invalid Account Number--->>>Enter a correct Account Number");
				}
				}
				catch(BankException e)
				{
					e.getMessage();
				}
			}
			return true;
				
		}
	//implements the account summary function of the project 
	private boolean casetwo()
	{
			System.out.println("ENTER THE ACCOUNT NUMBER:");
			while(true) {
				
				try {
				String accountnumber=sc.next();
				sc.nextLine();
				
				if(Validate.validatePattern(accountnumber, Validate.ACCOUNT_NUMBER_PATTERN)==true)
				{	
					if(passbook.verifyAccountService(accountnumber)==false)
						System.out.println("NO ACCOUNT ASSOCIATED TO THIS ACCOUNT NUMBER");
					else
					{
						while(true) 
						{
							System.out.println("ENTER DATE : IN FORMAT (DD-MM-YYYY)");
							System.out.println("FROM : ");
							String fromDate=sc.next();
							sc.nextLine();
							Date d1=Validate.dateValidator(fromDate);
							if(d1!=null)
							{	while(true)
								{
									System.out.println("TO : ");
									String toDate=sc.next();
									sc.nextLine();
									Date d2=Validate.dateValidator(toDate);
									if(d2!=null)
									{	
										passbook.accountSummary(accountnumber, d1, d2);
										break;
									}
									else
									{
										throw new BankException("Invalid Date  ->Enter a Valid Date");
									}
									}break;
								}
								else
								{
									throw new BankException("Invalid Date--->>Enter a Valid Date");
								}
							}
						}
						break;
					}
					else
					{
						throw new BankException("Invalid Account Number--->>Enter a correct Account Number");
					}
				}
				catch(BankException e)
				{
					e.getMessage();
				}
				}
			return true;
		}
	private boolean welcome()
	{
		System.out.println("------------BANK-------------");
		System.out.println("-----------------------------");
		System.out.println("WELCOME TO PASSBOOK MANAGEMENT");
		System.out.println("------------------------------");
		return true;
	}
	private boolean options()
	{
		System.out.println("PRESS 1 : UPADTE THE PASSBOOK");
		System.out.println("------------------------------");
		System.out.println("PRESS 2 : GET ACOOUNT SUMMARY");
		System.out.println("------------------------------");
		System.out.println("PRESS  3:       EXIT");
		System.out.println("------------------------------");
		return true;
	}
	private boolean print(String msg)
	{
		if(msg.equals("welcome"))
			welcome();
		if(msg.equals("options"))
			options();
		return true;
	}
}
