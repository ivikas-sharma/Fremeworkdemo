package com.automation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver startApp(WebDriver driver, String browserName, String appUrl) {
		String cwd = System.getProperty("user.dir");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", cwd+"/Drivers/chromedriver");
			driver = new ChromeDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", cwd+"/Drivers/geckodriver");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("IE")) {
			
		}
		else {
			System.out.println("We do not support this browser.");
		}
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
