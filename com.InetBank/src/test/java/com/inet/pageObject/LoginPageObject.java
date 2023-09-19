package com.inet.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
	WebDriver driver ;
	 public LoginPageObject(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	 
	@FindBy (name = "uid")
	@CacheLookup
	WebElement username ;
	
	@FindBy (name = "password")
	@CacheLookup
	WebElement passwordl;
	
	@FindBy(name ="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	
	
	
	public void setUserName(String uname) {
		username.sendKeys(uname);
	}
	public void setPassword(String password) {
		passwordl.sendKeys(password);
	}
	public void clickButton() {
		btnLogin.click();
	}

}
