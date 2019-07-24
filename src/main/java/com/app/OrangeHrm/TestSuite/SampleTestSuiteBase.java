package com.app.OrangeHrm.TestSuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.app.OrangeHrm.Ui.Selenium.Browser;
import com.app.OrangeHrm.utils.PropertParser;


public class SampleTestSuiteBase {

	protected WebDriver driver;
	protected Browser browser;

	//setting all browser property
	protected String browserName = PropertParser.readEnvOrConfigProperty("browserName");
	protected String os="windows";
	protected String osVersion="10";
	protected String browserVersion="45";
	
	//setting base url of application
	protected String webUrl = PropertParser.readEnvOrConfigProperty("applicaionUrl");
	
    @BeforeSuite
    public void preSetup() {
        browser = new Browser();
        this.driver = browser.getDriver();
        System.out.println("Browser name in props file: "+browserName);
    }
    
    public WebDriver getDriver() {
    	return browser.getDriver();
    }

    @AfterSuite
    public void teardown() {
        browser.closeBrowser();
    }
}
