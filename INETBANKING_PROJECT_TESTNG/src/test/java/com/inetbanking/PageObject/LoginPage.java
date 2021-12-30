package com.inetbanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		 
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUsername;

	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement btnlogout;
	

	public void setusername(String uname) {

		txtUsername.sendKeys(uname);

	}

	public void setpassword(String password) {

		txtPassword.sendKeys(password);

	}

	public void clkSubmit() {

		btnLogin.click();

	}
	
	public void clklogout() {

		btnlogout.click();

	}

}
