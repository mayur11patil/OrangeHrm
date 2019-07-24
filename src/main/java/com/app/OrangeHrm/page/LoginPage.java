package com.app.OrangeHrm.page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.app.OrangeHrm.constants.UiResourcePath;
import com.app.OrangeHrm.utils.PropertisUtil;

public class LoginPage {

	static Properties loginProps = PropertisUtil.loadProperty(UiResourcePath.LOGIN_PAGE);
	
	
	//all getters
	public static String getUserNameField() {
		return loginProps.getProperty("username_textbox");
	}
	public static String getPasswordField() {
		return loginProps.getProperty("password_textbox");
	}
	public static String getLoginButton() {
		return loginProps.getProperty("login_button");
	}
	
	
	
	//all actions(clicks, entering in fields)
	public boolean enterUserName(WebDriver driver, String uesrName) {
		driver.findElement(By.xpath(getUserNameField())).sendKeys(uesrName);
		System.out.println("entering userName: "+uesrName);
		return true;
	}
	
	public boolean enterPassword(WebDriver driver, String passowrd) {
		driver.findElement(By.xpath(getPasswordField())).sendKeys(passowrd);
		System.out.println("entering password: "+passowrd);
		return true;
	}
	
	//click action 
	public boolean clickOnLoginButton(WebDriver driver) {
		driver.findElement(By.xpath(getLoginButton())).click();
		System.out.println("Click on Login Button....");
		return true;
	}
	
	
}
