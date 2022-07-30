package com.automation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {
	
	@Test
	public void test1() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/V4/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("uid")).sendKeys("mngr427505");
		driver.findElement(By.name("password")).sendKeys("dyjUnaj");
		
		driver.findElement(By.name("btnLogin")).click();
		
		driver.quit();
	}

}
