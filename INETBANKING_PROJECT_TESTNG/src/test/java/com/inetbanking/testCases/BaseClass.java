package com.inetbanking.testCases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utils.ReadConfig;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.InternetExplorerDriverManager;

public class BaseClass {
	
	public static Logger logger;
	
	ReadConfig readconfig = new ReadConfig();
	
	public String APP_URL=readconfig.getApplicationUrl();
	public String  UserName=readconfig.getApplicationUserName();
	public String PassWORD=readconfig.getApplicationPassword();
	public String BROWSER="chrome";
	public static WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		

		logger  = Logger.getLogger("EBANKING");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			
		
		ChromeDriverManager.chromedriver().setup();				
		driver=new ChromeDriver();
		
		driver.get(APP_URL);

		}
		else if(br.equals("firefox")) {
			FirefoxDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(APP_URL);

			
		}else if(br.equals("ie")) {
			InternetExplorerDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			driver.get(APP_URL);

			
			
		}
		
		
		
		
	
		
	}
	
	
	/*
	 * @AfterClass public void tearDown() {
	 * 
	 * driver.quit();
	 * 
	 * }
	 */
	  
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
	 
}
