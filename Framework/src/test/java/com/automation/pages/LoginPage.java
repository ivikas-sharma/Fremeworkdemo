package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(name="uid1") WebElement uname;
	
	@FindBy(name="password") WebElement password;
	
	@FindBy(name="btnLogin") WebElement loginButton;
	
	
	public void loginUser(String usernameApp, String passwordApp) {
		uname.sendKeys(usernameApp);
		password.sendKeys(passwordApp);
		
		loginButton.click();
	}

}
