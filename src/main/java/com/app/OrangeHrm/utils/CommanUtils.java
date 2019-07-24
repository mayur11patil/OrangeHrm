package com.app.OrangeHrm.utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommanUtils {

	
	public static XlsReader getXlsReader(String testDataFile) {
		XlsReader xlsReader = new XlsReader();

		try {
			xlsReader.setPath(testDataFile);
			System.out.println("excel path set");
		} catch (IOException ioException) {
			return null;
		}
		return xlsReader;
	}
	
	public boolean isElementVisible(WebDriver driver, String xpath, long shortWaitTimeInSec) {

		WebDriverWait wait = new WebDriverWait(driver, shortWaitTimeInSec);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {
			
			return false;
		}
		return true;
	}
	
	public boolean isElementVisible(WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {
			
			return false;
		}
		return true;
	}

	public boolean isElementPresentAndClickable(WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		} catch (Exception exception) {
			return false;
		}
		return true;
	}

	public void acceptAlertIfPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			//if(wait.until(ExpectedConditions.alertIsPresent())!=null)
				driver.switchTo().alert().accept();
		} catch (Exception exception) {
			
		}
	}
	
	public static boolean isDisplayed(WebDriver driver, String XPathIsDisplayed ) {
		boolean isDisplayed = false;
		try {
			isDisplayed = driver.findElement(By.xpath(XPathIsDisplayed)).isDisplayed();
		}catch(Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}
	
	public void selectByVisibleText(WebDriver driver, String locatorValue, String value) {
		Select dropdown;
		WebElement element;
			element=driver.findElement(By.xpath(locatorValue));
			dropdown=new Select(element);
			dropdown.selectByVisibleText(value);
	}

}
