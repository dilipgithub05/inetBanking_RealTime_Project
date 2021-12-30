package com.inetbanking.testCases;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;

public class Tc_Login_test_001 extends BaseClass{
	
	
	@Test
	public void logintest() throws IOException {
		
		
		driver.get(APP_URL);
		
		logger.info("URL is Opened");
		LoginPage lp = new LoginPage(driver);
		lp.setusername(UserName);
		logger.info("Entered UserName");

		
		lp.setpassword(PassWORD);
		logger.info("Entered Password");

		lp.clkSubmit();
		
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passes");

			
		}
		else {
			captureScreen(driver, "logintest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");

		}
		
		
	}
	

}
