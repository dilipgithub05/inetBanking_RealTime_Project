package com.inetbanking.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Drivermanager_1 {
	private static WebDriver driver = null;

	
public static void launchbrower() {
		
		try {
			
			switch ("chrome") {
			case "chrome":
				ChromeDriverManager.chromedriver().setup();				
				driver=new ChromeDriver();
				break;
				
			case "firefox":
				ChromeDriverManager.firefoxdriver().setup();				
				driver=new FirefoxDriver();
				break;

			default:
				ChromeDriverManager.chromedriver().setup();				
				driver=new ChromeDriver();
				break;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public static WebDriver getDriver() {
		return driver;
	}
	

}
