package com.inet.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.inet.pageObject.LoginPageObject;
import com.inet.utilities.ReadConfig;



public class TC_loginTest_001 extends BaseClass{
	
	@Test
	void test1() {
		
		    


		   
		    LoginPageObject lop = new LoginPageObject(driver);
	    	
	    	
	    	// launch Firefox and direct it to the Base URL
	    	

            
		    // Enter username
		    logger.info("entering the username");
	        lop.setUserName(userName);
	        logger.info("enterning passwords");
	        lop.setPassword(password);
	        lop.clickButton();
	       String  actualTitle = driver.getTitle();
	        
			if (actualTitle.contains
					("Guru99 Bank Manager HomePage")) {
					    System.out.println("Test case: Passed");
			} 
			else {
					    System.out.println("Test case : Failed");
			}
					
		    driver.close();
		   

		   
	}

}
