package com.inet.testCase;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inet.pageObject.LoginPageObject;

public class TC_loginTest_003 extends BaseClass {
	//using dataProvider without excel 
	@DataProvider(name ="GuruTest")
	public Object[][] testData(){
		Object[][] data = new Object[4][2];
		data[0][0] = config.getUserName();
		data[0][1] = config.getPassword();
		data[1][0] = "invalid";
		data[1][1] = "valid";
		//3rd row
		data[2][0] = "valid";
		data[2][1] = "invalid";
		//4th row
		data[3][0] = "invalid";
		data[3][1] = "invalid";
		return data;
		
	}
	@Test(dataProvider = "GuruTest")
	public void LoginDDT(String usr, String psw) throws InterruptedException, IOException {
		
        
	     LoginPageObject lp = new  LoginPageObject (driver);
	     logger.info("entering the username");
	     lp.setUserName(usr);
	     logger.info("entering the password");
	     lp.setPassword(psw);
	     logger.info("click button");
	     lp.clickButton();	
	     Thread.sleep(3000);
	     
	     if(isAleartpresent() == true) {
	    	 
	    	
	    	 Alert alert = driver.switchTo().alert();
	         alert.accept();
	    	 
	    	
	    	
	    	 driver.switchTo().defaultContent();
	    	 captureScreenshot(driver, "invalid");
	    	 Assert.assertFalse(true);
	    	
	    	 logger.fatal("invalid user and password"+ usr );
	    	
	     }else {
	    	 
	    	 Assert.assertTrue(true);
	    	
	    	 lp.ClickLogout();
	    	 Thread.sleep(3000);
	    	 driver.switchTo().alert().accept();
	    	 driver.switchTo().defaultContent();
	    	 
	     }
	}
	public boolean isAleartpresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e) {
				return false;
		}
	}
    
}
