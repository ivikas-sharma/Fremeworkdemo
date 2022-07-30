package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;

public class LoginTest extends BaseClass  {
	
	
	@Test
	public void loginApp() {
		
		//this is a new comment for push to github
		logger = report.createTest("Login to guru99 demo");
		
		String uname = excel.getStringData("Login", 0, 0);
		String password = excel.getStringData(0, 0, 1);
		
		System.out.println("username: " + uname + " and password: " + password);
		
		logger.info("Starting Application...");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginUser(uname, password);
		logger.pass("Login done successfully");
		
	}

}
