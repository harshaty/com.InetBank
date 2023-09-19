package com.inet.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.inet.pageObject.LoginPageObject;
import com.inet.utilities.ReadConfig;



public class login1 {
	
	@Test
	void test1() {
		
		WebDriver driver = new ChromeDriver();


		    ReadConfig config = new ReadConfig();
		    LoginPageObject lop = new LoginPageObject(driver);
	    	String baseUrl = config.getBaseUrl();
	    	String username = config.getUserName();
	    	String password = config.getPassword();
	    	String titile = config.getHomePageConfirmation();
	    	
	    	// launch Firefox and direct it to the Base URL
	    	driver.get(baseUrl);

            
		    // Enter username
	        lop.setUserName(username);
	        lop.setPassword(password);
	        lop.clickButton();
	       String  actualTitle = driver.getTitle();
			if (actualTitle.contains(titile)) {
					    System.out.println("Test case: Passed");
			} 
			else {
					    System.out.println("Test case : Failed");
			}
					
		    driver.close();
		   

		   
	}

}
