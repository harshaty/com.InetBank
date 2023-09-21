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

	private ExtentReports extent;
	private ExtentTest test;
	
@SuppressWarnings("deprecation")
@Override
public void onStart(ITestContext testContext) {
	String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
	String repName = "Test-extent-repot"+timeStamp+".html";
	ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(repName);
	extent = new ExtentReports();
	final File file = new File("resource/extent-config.xml");
	htmlReport.loadXMLConfig(file);
	extent.attachReporter(htmlReport);
	
	
}
@Override
public void onTestStart(ITestResult result) {

	test = extent.createTest(result.getMethod().getMethodName());
}
	
@Override
public void onTestSuccess(ITestResult tr) {
	test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

}
@Override
public void onTestFailure(ITestResult tr) {
	test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	String screenShotPath = System.getProperty("user.dir")+ File.separator + "screenshot" +
	File.separator + tr.getName() + ".png";
	File f = new File(screenShotPath);
	if(f.exists() && f.isDirectory()) {
		try {
			test.fail("Screenshot is below :"+test.addScreenCaptureFromPath(screenShotPath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
@Override
public void onTestSkipped(ITestResult tr) {
	test.log(Status.SKIP, "test skipped");
}
@Override
public void onFinish(ITestContext testContext) {
	extent.flush();
}
}