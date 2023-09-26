package com.inet.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.http.WebSocket.Listener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports extends TestListenerAdapter{

	

		
		   private ExtentReports extent;
		   private ExtentTest test;
		   private static String screenshotName;
		   public static void setScreenshotName(String name) {
		        screenshotName = name;
		    }
			
			

		public void onStart(ITestContext testContext) {
			String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		    String repName ="Test-Report"+timeStamp+".html";

			@SuppressWarnings("deprecation")

			ExtentHtmlReporter htmlreport = new ExtentHtmlReporter(repName);
			extent = new ExtentReports();
		    final  File file = new File("resource/extent-config.xml");
		    htmlreport.loadXMLConfig(file);
			extent.attachReporter(htmlreport);

			


		}
		public void onTestStart(ITestResult tr) {
			test=  extent.createTest(tr.getMethod().getMethodName());
			
			
		}
		public void onTestSuccess(ITestResult tr) {
			test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
			
			
		}
		public void onTestFailure(ITestResult tr)   {
            String name = screenshotName;
			test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
			
			
			String screenshotPath =	System.getProperty("user.dir")+"/Screenshot/"+  name +".png";

			File f = new File(screenshotPath);

			// Verify the screenshot path
			System.out.println("Screenshot Path: " + screenshotPath);

			if (f.exists() && !f.isDirectory()) {
			    try {
			        // Ensure that 'test' is not null and the test is started
			        if (test != null) {
			        	test.fail("Screenshot is below:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			        } else {
			            System.err.println("Extent test instance is not initialized.");
			        }
			    } catch (IOException e) {
			        // Log the exception details
			        e.printStackTrace();
			    }
			} else {
			    System.err.println("Screenshot file does not exist: " + screenshotPath);
			





		    }
			
		}
		public void onTestSkipped(ITestResult tr) {
			test.log(Status.SKIP,"test skipped");
		}
		public void onFinish(ITestContext testContext) {
			extent.flush();
		}



		
}

