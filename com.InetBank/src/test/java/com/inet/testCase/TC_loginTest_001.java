package com.inet.testCase;


import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inet.pageObject.LoginPageObject;
import com.inet.utilities.xLUtils;

import org.testng.asserts.*;

public class TC_loginTest_001 extends BaseClass{
	
	@Test
	void test1() throws IOException {
    	// launch Firefox and direct it to the Base URL

			LoginPageObject lp = new LoginPageObject(driver);
			logger.info("username entered");
			lp.setUserName(username);
			logger.info("Password entered");
			lp.setPassword(password);
			logger.info("clicking the button");
			lp.clickButton();
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
				Assert.assertTrue(true);
				

				

			}else {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				captureScreenshot(driver,"loginTest");
				Assert.assertTrue(false);
			}
		   

		   
	}
	

}
