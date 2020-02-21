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
AccountsDao acoountsdao=new AccountsDao();
TransactionDao transactiondao=new TransactionDao();
Client client=new Client();

		
	


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
		
		
		assertTrue(acoountsdao.verifyAccount(validaccountnumber));
		assertFalse(acoountsdao.verifyAccount(invalidaccountnumber1));
		assertFalse(acoountsdao.verifyAccount(invalidaccountnumber2));
		assertFalse(acoountsdao.verifyAccount(invalidaccountnumber3));
		assertFalse(acoountsdao.verifyAccount(invalidaccountnumber4));
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
		assertEquals(validdate,acoountsdao.getLastPassbookUpdateDate(validaccountnumber));
	}
	
	
	
	@Test
	public void updateBalanceDaoTest()
	{
		assertEquals(17000.0,transactiondao.updateBalance("300080705006"));
	}

	@Test
	public void getAccountDetailsDaoTest()
	{
		assertTrue(acoountsdao.getAccountDetails("300080705006"));
	}
	
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	@Test
	public void accountSummaryDaoTest() throws ParseException
	{
		assertTrue(transactiondao.accountSummary("300080705006", sdf.parse("15-01-2019"), sdf.parse("20-12-2019")));
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
