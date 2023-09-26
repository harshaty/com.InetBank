package com.inet.testCase;

import org.testng.TestListenerAdapter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.inet.utilities.ReadConfig;
import com.inet.utilities.Reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
	public static WebDriver driver;
	ReadConfig config = new ReadConfig();
	public String username = config.getUserName();
	public String password =config.getPassword();
	public String url = config.getBaseUrl();
	public static Logger  logger;
	public ExtentTest test;
	public String lastScreenshotName;
	
	@BeforeClass
	
	public void setUp() {

	    System.setProperty("log4j.configurationFile", "/home/harshan/git/repository/com.InetBank/resource/log4j2.xml");
         
        // Obtain the Logger instance for this class
           logger = LogManager.getLogger(BaseClass.class);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.get(url);
		

		


				}
		

	
	@AfterClass
	public void TearDown()  {
		driver.quit();
	}
		
	
	public void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
	
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String uniqueScreenshotName = screenshotName + "_" + timestamp;
		lastScreenshotName =uniqueScreenshotName;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destpath = System.getProperty("user.dir")+"/Screenshot/"+  uniqueScreenshotName +".png";
		File destination = new File(destpath);
		FileUtils.copyFile(source,destination);
		System.out.println("screenshot taken");
		Reports.setScreenshotName( uniqueScreenshotName);
		
	
	}
	

	

}