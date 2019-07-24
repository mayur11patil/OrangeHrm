package com.app.OrangeHrm.helpers;

import org.openqa.selenium.WebDriver;

import com.app.OrangeHrm.Ui.Selenium.Browser;
import com.app.OrangeHrm.page.LoginPage;
import com.app.OrangeHrm.utils.XlsReader;

public class LoginHelpers {

	Browser browser = new Browser();
	LoginPage loginPage = new LoginPage();
	
	
	String sheetName="";
	
	public LoginHelpers(String sheetName) {
		this.sheetName=sheetName;
	}
	
	
	public Browser launchURL(String webURL,String os, String osVersion, String browserName, String browserVersion) {
		
		browser.openURL(webURL, os, osVersion, browserName, browserVersion);
		browser.getDriver().manage().window().maximize();
		
		return browser;
	}
	
	public boolean doAdminLogin(WebDriver driver, XlsReader xlsReader, int row) {
	
		String userName=xlsReader.getCellDataByColumnName(sheetName, "AdminUsername", row);
		String password=xlsReader.getCellDataByColumnName(sheetName, "AdminPassword", row);
		
		return adminLogin(driver, userName, password);
	}
	
	public boolean adminLogin(WebDriver driver, String userName, String password) {
		System.out.println("login admin as "+userName);
		if(loginPage.enterUserName(driver, userName))
			if(loginPage.enterPassword(driver, password));
				loginPage.clickOnLoginButton(driver);
		
		return true;
	}
}
