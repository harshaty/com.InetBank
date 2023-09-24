package com.inet.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inet.pageObject.LoginPageObject;
import com.inet.utilities.xLUtils;

public class TC_loginTest_002 extends BaseClass{
	
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
	public void LoginDDT(String usr, String psw) throws InterruptedException {
		
        
	     LoginPageObject lp = new LoginPageObject(driver);
	     logger.info("entering the username");
	     lp.setUserName(usr);
	     logger.info("entering the password");
	     lp.setPassword(psw);
	     logger.info("click button");
	     lp.clickButton();
	     Thread.sleep(3000);
	     if(isAleartpresent() == true) {
	    	 driver.switchTo().alert().accept();
	    	 driver.switchTo().defaultContent();
	    	 Assert.assertTrue(false);
	    	 logger.fatal("invalid user and password"+ usr );
	     }else {
	    	 Assert.assertTrue(true);
	    	 lp.ClickLogout();
	    	 Thread.sleep(3000);
	    	 driver.switchTo().alert().accept();
	    	 driver.switchTo().defaultContent();
	     }
	}
	
}
	

	
	



