package com.inet.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig(){
		try {
		File src = new File("./config/config.properties");
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		}catch(Exception e) {
			System.out.println("file not found");
		}
		
	}
	public String getUserName() {
		String username = pro.getProperty("UserName");
		return username;
	}
	public String getPassword() {
		String pasw = pro.getProperty("Password");
		return pasw;
	}
	public String getBaseUrl() {
		String url = pro.getProperty("BaseUrl");
		return url;
	}
	public String getHomePageConfirmation() {
		String  homePage = pro.getProperty("EXPECT_TITLE");
		return homePage;
	}

}
