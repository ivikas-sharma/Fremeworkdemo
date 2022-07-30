package com.automation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(reporter);
	}

	@BeforeClass
	public void setup() {
		String appUrl = config.getUrl();
		String browser = config.getBrowser();

		driver = BrowserFactory.startApp(driver, browser, appUrl);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				String capturesScreenshotPath = Helper.captureScreenshot(driver);
				logger.fail("Login Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(capturesScreenshotPath).build());
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				String capturesScreenshotPath = Helper.captureScreenshot(driver);
				logger.pass("Login Success",
						MediaEntityBuilder.createScreenCaptureFromPath(capturesScreenshotPath).build());
			}
		} catch (Exception e) {
			System.out.println("screenshot not attached to report due to : " + e.getMessage());
		}
		report.flush();
	}

}
