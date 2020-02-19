package com.capgemini.bank.ui;

import java.util.Date;
import java.util.Scanner;

import com.capgemini.bank.service.PassbookService;
import com.capgemini.bank.validator.Validate;

public class Client {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//scanner class object created to take input
		PassbookService passbook=new PassbookService();
		//Service class object created to communicate with the service and dao classes
		DisplayData display=new DisplayData();
		//display class object created to display information
		display.print("welcome");

		while(true)   //loop to take valid input from user
		{
			display.print("options");
			String choice=sc.next();    //user input to ask for choices
			sc.nextLine();
			boolean c;
			try {
				c = Validate.choiceValidator(choice);
				//validation of choice variable
			} catch (Exception e) {
				System.out.println("INVALID CHOICE ENTERED ONLY NUBERS ALLOWED");
				System.out.println("ENTER A VALID NUMBER");
				continue;
			}
			if(c==false)
			{	
				System.out.println("INVALID CHOICE");
				System.out.println("ENTER A VALID NUMBER");
				continue;
			}
			
			else {
			switch(choice)
			//switch block to validate different entries
			{
			case "1":
			{
				System.out.println("ENTER THE ACCOUNT NUMBER:");
				while(true) {
					String acc_num=sc.next();
					sc.nextLine();
					boolean b=Validate.validatePattern(acc_num, Validate.account_number_pattern);
					if(b==true)
					{	
						if(passbook.verifyAccountService(acc_num)==false)
						{
							System.out.println("NO ACCOUNT ASSOCIATED TO THIS ACCOUNT NUMBER");
						}
						else
							passbook.updatePassbook(acc_num);
						break;
					}
					else
					{
						System.out.println("Invalid Account Number");
						System.out.println("Enter a correct Account Number");
					}
				}
					break;
			}
			case "2":
			{
				System.out.println("ENTER THE ACCOUNT NUMBER:");
				while(true) {
					String acc_num=sc.next();
					sc.nextLine();
					boolean b=Validate.validatePattern(acc_num, Validate.account_number_pattern);
					if(b==true)
					{	
						if(passbook.verifyAccountService(acc_num)==false)
							System.out.println("NO ACCOUNT ASSOCIATED TO THIS ACCOUNT NUMBER");
						else
						{
							while(true) 
							{
								System.out.println("ENTER DATE : IN FORMAT (DD-MM-YYYY)");
								System.out.println("FROM : ");
								String from_date=sc.next();
								sc.nextLine();
								Date d1=Validate.dateValidator(from_date);
								if(d1!=null)
								{	while(true)
									{
										System.out.println("TO : ");
										String to_date=sc.next();
										sc.nextLine();
										Date d2=Validate.dateValidator(to_date);
										if(d2!=null)
										{	
											passbook.accountSummary(acc_num, d1, d2);
											break;
										}
										else
										{
											System.out.println("Invalid Date");
											System.out.println("Enter a Valid Date");
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
							
							break;
					}
			case "3":
			{
				System.out.println("Thank You For Using The Passbook Management");
				System.out.println("--------------------------------------------");
				sc.close();
				break;
				//System.exit(0);
				
			}
			default:
			{
				System.out.println("INVALID CHOICE");
				System.out.println("ENTER A VALID CHOICE");
				
			}
			}
			}
		
			}	
	}
}
