package com.app.OrangeHrm.Ui.Selenium;

import org.openqa.selenium.WebDriver;

import com.app.OrangeHrm.Ui.SelniumInterface.IBrowser;
import com.app.OrangeHrm.Ui.SelniumInterface.IDistributionManagement;

public class Browser implements IBrowser {
	
	WebDriver driver;

	public boolean openURL(String url, String os, String osVersion, String browser, String browserVersion) {
		boolean isOpenURL = false;
		String environment = "local";

		RunModeFactory factory = new RunModeFactory();
		
		IDistributionManagement distributionManager = factory.getRunMode(environment, os, osVersion, browser,
				browserVersion);
		this.driver = distributionManager.getDriver();
		System.out.println(driver);
		System.out.println(url);
		isOpenURL = validateURL(url);

		return isOpenURL;
	}

	public boolean validateURL(String url) {
		driver.get(url);
		return true;
	}
	public boolean closeBrowser() {
		// TODO Auto-generated method stub
		System.out.println("close browser called");
		return false;
	}

	public boolean quitBrowser() {
		// TODO Auto-generated method stub
		System.out.println("quit browser called");
		return false;
	}

	public boolean openUrl() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
