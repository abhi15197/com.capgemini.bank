package com.capgemini.bank.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface Validate {
	String ACCOUNT_NUMBER_PATTERN="^[1-9][0-9]{11}";
	SimpleDateFormat DATEFORMAT = new SimpleDateFormat("dd-MM-yyyy");
	String CHOICE_PATTERN="^[0-9]*";

	public static boolean validatePattern(String data,String pattern)
	{
		return data.matches(pattern);
	}

	
	public static Date dateValidator(String dateToValidate)
	{
		if(dateToValidate == null){
			return null;
		}
		try {
			//if not valid, it will throw ParseException
			Date date=DATEFORMAT.parse(dateToValidate);
			Date now=DATEFORMAT.parse(DATEFORMAT.format(new Date()));
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

