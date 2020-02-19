package com.capgemini.bank.ui;

public class DisplayData {
	
	
	private void welcome()
	{
		System.out.println("------------BANK-------------");
		System.out.println("-----------------------------");
		System.out.println("WELCOME TO PASSBOOK MANAGEMENT");
		System.out.println("------------------------------");
	}
	private void options()
	{
		System.out.println("PRESS 1 : UPADTE THE PASSBOOK");
		System.out.println("------------------------------");
		System.out.println("PRESS 2 : GET ACOOUNT SUMMARY");
		System.out.println("------------------------------");
		System.out.println("PRESS  3:       EXIT");
		System.out.println("------------------------------");
	}
	protected void print(String msg)
	{
		if(msg.equals("welcome"))
			welcome();
		if(msg.equals("options"))
			options();	
	}
	

}
