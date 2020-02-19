package com.capgemini.bank.ui;

import java.util.Date;
import java.util.Scanner;

import com.capgemini.bank.service.PassbookService;
import com.capgemini.bank.validator.Validate;

public class Client {
	//scanner class object created to take input
	static Scanner sc=new Scanner(System.in);
	
	
	//Service class object created to communicate with the service and dao classes
	static PassbookService passbook=new PassbookService();
	public static void main(String[] args) {
		
		Client object=new Client();
		object.print("welcome");
		boolean loopbreaker=false;
		
		
		while(true)   //loop to take valid input from user
		{
			object.print("options");
			String choice=sc.next();    //user input to ask for choices
			sc.nextLine();
				//validation of choice variable
			if(!Validate.validatePattern(choice, Validate.CHOICE_PATTERN))
				System.out.println("INVALID CHOICE  ->ENTER A VALID NUMBER");
				
		
			else
			{
				switch(choice)
				//switch block to validate different entries
				{
				
				case "1":
				{
					object.caseone();
					break;
				}
				case "2":
				{
					object.casetwo();
					break;
				}
				//implements the exit stage of the program
				case "3":
				{
					System.out.println("Thank You For Using The Passbook Management");
					System.out.println("--------------------------------------------");
					sc.close();
					loopbreaker=true;
					break;
					
				}
				default:
				{
					System.out.println("INVALID CHOICE");
					System.out.println("ENTER A VALID CHOICE");	
					break;
				}
				}
			}
			
			if(loopbreaker)
				break;
		}	
	}
	
	
	//implements the passbook update funtion of the project
	private boolean caseone()
	{
		
		
			System.out.println("ENTER THE ACCOUNT NUMBER:");
			while(true) {
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
					System.out.println("Invalid Account Number");
					System.out.println("Enter a correct Account Number");
				}
			}
			return true;
				
		}
	//implements the account summary function of the project 
	private boolean casetwo()
	{
			System.out.println("ENTER THE ACCOUNT NUMBER:");
			while(true) {
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
										System.out.println("Invalid Date  ->Enter a Valid Date");
									}
									}break;
								}
								else
								{
									System.out.println("Invalid Date");
									System.out.println("Enter a Valid Date");
								}
							}
						}
						break;
					}
					else
					{
						System.out.println("Invalid Account Number");
						System.out.println("Enter a correct Account Number");
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
