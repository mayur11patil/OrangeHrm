package com.app.OrangeHrm.TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.OrangeHrm.TestSuite.SampleTestSuiteBase;
import com.app.OrangeHrm.constants.UiResourcePath;
import com.app.OrangeHrm.helpers.LoginHelpers;
import com.app.OrangeHrm.utils.CommanUtils;
import com.app.OrangeHrm.utils.XlsReader;

public class SampleTestScript extends SampleTestSuiteBase {
	
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
	public void sampleTest() throws InterruptedException {
	
		browser = loginhelper.launchURL(webUrl, os, osVersion, browserName, browserVersion);
		driver = browser.getDriver();
		
		driver.findElement(By.xpath("//span[@class='userNameIcon whiteText makeFlex perfectCenter latoBlack appendRight10']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[contains(text(),' Create New Account ')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hdhdh@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("45@Gjjjjjjjjj");
		Thread.sleep(5000);
		/*WebElement element = driver.findElement(By.xpath("//button[@class='capText font16']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);*/
		driver.findElement(By.xpath("(//span[text()='Login'])[1]")).click();
		
	}
	
	//@Test
	public void test1() {
		browser = loginhelper.launchURL(webUrl, os, osVersion, browserName, browserVersion);
		driver = browser.getDriver();
		loginhelper.doAdminLogin(driver, xlsReader, 1);
		
	}
	@Test
	public void a() {
		
	}

}
