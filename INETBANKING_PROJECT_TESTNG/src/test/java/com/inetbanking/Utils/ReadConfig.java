package com.inetbanking.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configurator/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		
		String url = pro.getProperty("APP_URL");
		return url;
		
		
	}
	
	public String getApplicationUserName() {
		
		String UserName = pro.getProperty("UserName");
		return UserName;
		
		
	}
	
	public String getApplicationPassword() {
		
		String PassWORD = pro.getProperty("PassWORD");
		return PassWORD;
		
		
	}
}
