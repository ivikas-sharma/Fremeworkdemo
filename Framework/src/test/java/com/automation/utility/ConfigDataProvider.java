package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		File src = new File("./Config/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Issue in reading config file: " + e.getMessage());
		} 
	}
	
	
	public String getDataFromConfig(String key) {
		return pro.getProperty(key);
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getUrl() {
		return pro.getProperty("appUrl");
	}

}
