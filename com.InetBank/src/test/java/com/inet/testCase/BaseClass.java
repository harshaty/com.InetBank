package com.inet.testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.ExtentTest;
import com.inet.utilities.ReadConfig;

public class BaseClass {
	
	public static  WebDriver driver;
	public ReadConfig config = new ReadConfig();
	public String userName = config.getUserName();
	public String password = config.getPassword();
	public String BaseUrl = config.getBaseUrl();
	
	public ExtentTest report;
	  public static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(BaseClass.class.getName());
	//@Parameter("browser")
	@BeforeMethod
	@BeforeClass
	public void setUp() {
		// as per the new version it automatically set the driver
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(BaseUrl);
		
		
	}
	@AfterClass
	public void TearDown() {
		 driver.quit();
	}
	
	
	
	

}
