package com.app.OrangeHrm.TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.OrangeHrm.TestSuite.SampleTestSuiteBase;
import com.app.OrangeHrm.constants.UiResourcePath;
import com.app.OrangeHrm.helpers.AdminHelpers;
import com.app.OrangeHrm.helpers.LoginHelpers;
import com.app.OrangeHrm.utils.CommanUtils;
import com.app.OrangeHrm.utils.XlsReader;

public class SearchEmployee extends SampleTestSuiteBase {


	AdminHelpers adminHelper = new AdminHelpers();
	CommanUtils commanUtil = new CommanUtils();
	WebDriver driver;
	XlsReader xlsReader = null;
	
	String testDataSheet = UiResourcePath.TEST_DATA_ADMIN_SHEET;
	LoginHelpers loginhelper = new LoginHelpers(testDataSheet);
	
	@BeforeTest
	public void prSetup() {
		System.out.println("path = "+UiResourcePath.getTestDataFilePath());
		xlsReader = CommanUtils.getXlsReader("D:\\CreditSightsAStaging\\OrangeHrm\\Resources\\testdata\\OrangeHrmTestData.xlsx");
	}
	
	@Test
	public void testSearchEmployeeById() {
		browser = loginhelper.launchURL(webUrl, os, osVersion, browserName, browserVersion);
		driver = browser.getDriver();
		loginhelper.doAdminLogin(driver, xlsReader, 1);
		
		adminHelper.navigateToEmployeeList(driver);
		Assert.assertTrue(adminHelper.searchById(driver));
	}
	
	@Test
	public void testSearchByEmployeeName() {
		browser = loginhelper.launchURL(webUrl, os, osVersion, browserName, browserVersion);
		driver = browser.getDriver();
		loginhelper.doAdminLogin(driver, xlsReader, 1);
		
		adminHelper.navigateToEmployeeList(driver);
		Assert.assertTrue(adminHelper.searchByEmployeeName(driver));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
