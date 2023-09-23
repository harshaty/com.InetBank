package com.inet.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports extends TestListenerAdapter{

	
<<<<<<< HEAD
		
		   private ExtentReports extent;
		   private ExtentTest test;
=======
	
		
		 
>>>>>>> 67952964a7bfd36262abad7b722635cb29759035
		   
			
			

		public void onStart(ITestContext testContext) {
			String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		    String repName ="Test-Report"+timeStamp+".html";
<<<<<<< HEAD
			@SuppressWarnings("deprecation")
=======
>>>>>>> 67952964a7bfd36262abad7b722635cb29759035
			ExtentHtmlReporter htmlreport = new ExtentHtmlReporter(repName);
			extent = new ExtentReports();
		    final  File file = new File("resource/extent-config.xml");
		    htmlreport.loadXMLConfig(file);
			extent.attachReporter(htmlreport);

			
<<<<<<< HEAD

		}
		public void onTestStart(ITestResult tr) {
			test=  extent.createTest(tr.getMethod().getMethodName());
			
			
		}
		public void onTestSuccess(ITestResult tr) {
			test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
			
			
		}
		public void onTestFailure(ITestResult tr)   {
			test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
			
			String screeshotPath = System.getProperty("user.dir") + File.separator + "Screenshot" + File.separator + tr.getName() + ".png";
		    
			File f = new File(screeshotPath);
			
		    if(f.exists() && f.isDirectory()) {
		    	try {
		    		test.fail("Screenshot is below:\n"+test.addScreenCaptureFromPath(screeshotPath));
		    		
		    	}catch(IOException e) {
		    		e.printStackTrace();
		    	}
		    }
			
		}
		public void onTestSkipped(ITestResult tr) {
			test.log(Status.SKIP,"test skipped");
		}
		public void onFinish(ITestContext testContext) {
			extent.flush();
		}
}
=======

		}
		public void onTestStart(ITestResult tr) {
			test=  extent.createTest(tr.getMethod().getMethodName());
			
			
		}
		public void onTestSuccess(ITestResult tr) {
			test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
			
			
		}
		public void onTestFailure(ITestResult tr)   {
			test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
			
			String screeshotPath = System.getProperty("user.dir") + File.separator + "Screenshot" + File.separator + tr.getName() + ".png";
		    
			File f = new File(screeshotPath);
			
		    if(f.exists() && f.isDirectory()) {
		    	try {
		    		test.fail("Screenshot is below:\n"+test.addScreenCaptureFromPath(screeshotPath));
		    		
		    	}catch(IOException e) {
		    		e.printStackTrace();
		    	}
		    }
			
		}
		public void onTestSkipped(ITestResult tr) {
			test.log(Status.SKIP,"test skipped");
		}
		public void onFinish(ITestContext testContext) {
			extent.flush();
		}

		}
>>>>>>> 67952964a7bfd36262abad7b722635cb29759035
