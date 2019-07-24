package com.app.OrangeHrm.TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.OrangeHrm.TestSuite.SampleTestSuiteBase;
import com.app.OrangeHrm.constants.UiResourcePath;
import com.app.OrangeHrm.helpers.AdminHelpers;
import com.app.OrangeHrm.helpers.DashboardHelpers;
import com.app.OrangeHrm.helpers.LoginHelpers;
import com.app.OrangeHrm.utils.CommanUtils;
import com.app.OrangeHrm.utils.XlsReader;

public class DashboardAssignLeaveTestScript extends SampleTestSuiteBase{

	AdminHelpers adminHelper = new AdminHelpers();
	CommanUtils commanUtil = new CommanUtils();
	DashboardHelpers dashboardhelper = new DashboardHelpers();
	WebDriver driver;
	XlsReader xlsReader = null;
	
	String testDataSheet = UiResourcePath.TEST_DATA_ADMIN_SHEET;
	LoginHelpers loginhelper = new LoginHelpers(testDataSheet);
	
	@BeforeTest
	public void prSetup() {
		System.out.println("path = "+UiResourcePath.getTestDataFilePath());
		xlsReader = CommanUtils.getXlsReader("D:\\CreditSightsAStaging\\OrangeHrm\\Resources\\testdata\\OrangeHrmTestData.xlsx");
	}
	
	@Test(priority = 1)
	public void testAssignLeave() {
		browser = loginhelper.launchURL(webUrl, os, osVersion, browserName, browserVersion);
		driver = browser.getDriver();
		loginhelper.doAdminLogin(driver, xlsReader, 1);
		
		Assert.assertTrue(dashboardhelper.assignLeave(driver));
		
	}
	
	//@Test(priority = 2)
	public void testViewLeaveList() {
		browser = loginhelper.launchURL(webUrl, os, osVersion, browserName, browserVersion);
		driver = browser.getDriver();
		loginhelper.doAdminLogin(driver, xlsReader, 1);
		
		Assert.assertTrue(dashboardhelper.viewLeaveList(driver));
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
