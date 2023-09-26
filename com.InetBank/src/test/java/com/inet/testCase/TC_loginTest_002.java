package com.inet.testCase;


import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inet.pageObject.LoginPageObject;
import com.inet.utilities.xLUtils;

public class TC_loginTest_002 extends BaseClass{
	 Alert alert ;
	
	public boolean isAleartpresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e) {
				return false;
		}
	}
    
		
		@DataProvider(name ="LoginData")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir") + "/src/test/java/com/inet/testData/harsha.xlsx";
		int rownum = xLUtils.getRowCount(path,"sheet1");
		int coloum = xLUtils.getCellCount(path, "sheet1", 1);
		
		String LoginData[][] = new String[rownum][coloum];
		for(int i =1;i <=rownum; i++) {
			for(int j =0; j<coloum;j++) {
				LoginData[i-1][j] = xLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return LoginData;
	}
	
	@Test(dataProvider = "LoginData")
	public void LoginDDT(String usr, String psw) throws InterruptedException, IOException {
		
        
	     LoginPageObject lp = new LoginPageObject(driver);
	     logger.info("entering the username");
	     lp.setUserName(usr);
	     logger.info("entering the password");
	     lp.setPassword(psw);
	     logger.info("click button");
	     lp.clickButton();
	     Thread.sleep(3000);
	     if (isAleartpresent()) {
	    		
	    	 
	    	    try {
	    	        // Capture a screenshot of the alert dialog
	    	       
	    	        // Switch to the alert
	    	    	
	    	         driver.switchTo().alert().accept();
	    	        
	    	        // Get the text of the alert (optional, for logging purposes)
	    	      
	    	        captureScreenshot(driver, "invalid");
	    	        // Accept the alert (you can dismiss it if needed)
	    	       
	    	        
	    	        // Switch back to the default content (optional, if needed)
	    	        driver.switchTo().defaultContent();
	    	    } catch (Exception e) {
	    	        System.out.println("Unable to take screenshot or handle alert: " + e.getMessage());
	    	        captureScreenshot(driver, "alert_screenshot");   	    }

	    	    // Your assertion or other test logic here
	    	    Assert.assertFalse(true);
	    	    logger.fatal("Invalid user and password: " + usr);
	    	
	    	





	    	
	     }else {
	    	
	    	 Assert.assertTrue(true);
	    	 lp.ClickLogout();
	    	
	    	 Thread.sleep(3000);
	    	 captureScreenshot(driver, "logout_log");
	    	 Thread.sleep(3000);
	    	 driver.switchTo().alert().accept();
	    	 driver.switchTo().defaultContent();
	     }
	}
	
}
	

	
	



