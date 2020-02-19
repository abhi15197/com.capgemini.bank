package com.capgemini.bank;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

import com.capgemini.bank.dao.AccountsDao;
import com.capgemini.bank.dao.TransactionDao;
import com.capgemini.bank.service.PassbookService;
import com.capgemini.bank.ui.Client;
import com.capgemini.bank.util.AccountsUtil;
import com.capgemini.bank.util.TransactionUtil;
import com.capgemini.bank.validator.Validate;




public class BankTest {
	
PassbookService service=new PassbookService();
AccountsDao obj1=new AccountsDao();
TransactionDao obj2=new TransactionDao();
Client obj3=new Client();

		//Class service=Class.forName(PassbookService);
		//Class service=Class.forName(AccountsDao);
	


	//test to verify the vadility of verify account method in service class
	@Test
	public void VerifyAccountServiceTest() {
		String validaccountnumber="300080705005";
		String invalidaccountnumber1="123456789012";
		String invalidaccountnumber2="123456789";
		String invalidaccountnumber3="any invalid string";
		String invalidaccountnumber4="any invalid string+1515";
		
		
		assertTrue(service.verifyAccountService(validaccountnumber));
		assertFalse(service.verifyAccountService(invalidaccountnumber1));
		assertFalse(service.verifyAccountService(invalidaccountnumber2));
		assertFalse(service.verifyAccountService(invalidaccountnumber3));
		assertFalse(service.verifyAccountService(invalidaccountnumber4));
	}
	
	
	
	
	
	
	//test to verify the vadility of verify account method in dao class
	@Test
	public void VerifyAccountDAOTest() {
		String validaccountnumber="300080705005";
		String invalidaccountnumber1="123456789012";
		String invalidaccountnumber2="123456789";
		String invalidaccountnumber3="any invalid string";
		String invalidaccountnumber4="any invalid string+1515";
		
		
		assertTrue(obj1.verifyAccount(validaccountnumber));
		assertFalse(obj1.verifyAccount(invalidaccountnumber1));
		assertFalse(obj1.verifyAccount(invalidaccountnumber2));
		assertFalse(obj1.verifyAccount(invalidaccountnumber3));
		assertFalse(obj1.verifyAccount(invalidaccountnumber4));
	}
	
	
	
	
	
	//test to verify the vadility of getLastPassbookUpdateDate method in dao class
	Date validdate;
	@Test
	public void getPassbookUpdateDateDAOTest() {
		String validaccountnumber="300080705005";
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		try {
			validdate = sdf.parse("18-02-2017");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals(validdate,obj1.getLastPassbookUpdateDate(validaccountnumber));
	}
	
	
	
	@Test
	public void updateBalanceDaoTest()
	{
		assertEquals(17000.0,obj2.updateBalance("300080705006"));
	}

	@Test
	public void getAccountDetailsDaoTest()
	{
		assertTrue(obj1.getAccountDetails("300080705006"));
	}
	
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	@Test
	public void accountSummaryDaoTest() throws ParseException
	{
		assertTrue(obj2.accountSummary("300080705006", sdf.parse("15-01-2019"), sdf.parse("20-12-2019")));
	}
	
	
	//test to validate if the getAccount method in util class returns the collection or not
	@Test
	public void getAccountTest()
	{
		assertFalse(AccountsUtil.getAccount().isEmpty());
	}
	
	
	
	
	
	//test to validate if the getTransaction method in util class returns the collection or not
	@Test
	public void getTransactionTest()
	{
		assertFalse(TransactionUtil.getTransaction().isEmpty());
	}

	
	
	@Test
	public void validatePatternTest()
	{	//validates if acccount number entered by the user is of 12 size of length also checks if it is a number  
		assertTrue(Validate.validatePattern("121212121212", Validate.ACCOUNT_NUMBER_PATTERN));
		assertFalse(Validate.validatePattern("151515", Validate.ACCOUNT_NUMBER_PATTERN));
		
		
		//validate the choice entered by user is number or not
		assertTrue(Validate.validatePattern("15151",Validate.CHOICE_PATTERN));
		assertFalse(Validate.validatePattern("adssds",Validate.CHOICE_PATTERN));
	}
	
	

}
