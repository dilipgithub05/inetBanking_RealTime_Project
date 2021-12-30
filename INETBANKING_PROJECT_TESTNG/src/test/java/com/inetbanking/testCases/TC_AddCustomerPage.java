package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;



public class TC_AddCustomerPage extends BaseClass{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
		
		driver.get(APP_URL);

		com.inetbanking.PageObject.LoginPage lp=new LoginPage(driver);
		lp.setusername(UserName);
		logger.info("User name is provided");
		lp.setpassword(PassWORD);
		logger.info("Passsword is provided");
		lp.clkSubmit();
		
		Thread.sleep(3000);
		
		com.inetbanking.PageObject.AddCustomerPage addcust=new com.inetbanking.PageObject.AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Dilip");
		addcust.custgender("male");
		addcust.custdob("21","09","2001");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}

	private String randomestring() {
		// TODO Auto-generated method stub
		
		String generatedString =RandomStringUtils.randomAlphabetic(8);
		
		return (generatedString);
	}
}
