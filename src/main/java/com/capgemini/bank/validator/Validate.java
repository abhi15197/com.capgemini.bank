package com.capgemini.bank.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public interface Validate {
	String account_number_pattern="^[1-9][0-9]{11}";
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy");

	public static boolean validatePattern(String data,String pattern)
	{
		return data.matches(pattern);
	}
	public static boolean choiceValidator(String choice) 
	{
		try{
			Integer.parseInt(choice);
			return true;
		}
		catch(InputMismatchException e)
		{	
			return false;
		}
		
	}
	
	public static Date dateValidator(String dateToValidate)
	{
		if(dateToValidate == null){
			return null;
		}
		try {
			//if not valid, it will throw ParseException
			Date date=dateformat.parse(dateToValidate);
			Date now=dateformat.parse(dateformat.format(new Date()));
			if(date.after(now))
			{		
					return null;}
			else {
				return date;
			}
		} catch (ParseException e) {
			
			return null;
		}	
	}
}

