package com.inet.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login1 {
	
	@Test
	void test1() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();


		
	    	String baseUrl = "http://www.demo.guru99.com/V4/";
	    	
	    	// launch Firefox and direct it to the Base URL
	    	driver.get(baseUrl);


		    // Enter username
		    driver.findElement(By.name("uid")).sendKeys("mngr1336");

		    // Enter Password
		    driver.findElement(By.name("password")).sendKeys("dAnavUq");
		   
		    // Click Login
		    driver.findElement(By.name("btnLogin")).click();
	}

}
