package com.app.OrangeHrm.page;

import java.awt.Menu;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.app.OrangeHrm.constants.UiResourcePath;
import com.app.OrangeHrm.utils.CommanUtils;
import com.app.OrangeHrm.utils.PropertisUtil;

public class AdminPage {

	static Properties adminProps = PropertisUtil.loadProperty(UiResourcePath.ADMIN_PAGE);
	CommanUtils commanutil = new CommanUtils();
	
	
	//all getters
	public static String getAdminMenuLinks(String menuName) {
		return adminProps.getProperty("adminmenu_links").replace("xxxxx", menuName);
	}
	public static String getPasswordField(String menuName) {
		return adminProps.getProperty("pimmenu_links").replace("xxxxx", menuName);
	}
	public static String getEmployeeIdField() {
		return adminProps.getProperty("employee_id_textbox");
	}
	
	public static String getFirstNameField() {
		return adminProps.getProperty("firstname_textbox");
	}
	public static String getMiddleNameField() {
		return adminProps.getProperty("middleName_textbox");
	}
	public static String getLastNameField() {
		return adminProps.getProperty("lastName_textbox");
	}
	public static String getPhotographFile() {
		return adminProps.getProperty("photograph_file");
	}
	
	public static String getCreateLoginCheckbox() {
		return adminProps.getProperty("create_login_details_checkbox");
	}
	public static String getUsernameField() {
		return adminProps.getProperty("username_textbox");
	}
	public static String getPasswordField() {
		return adminProps.getProperty("password_textbox");
	}
	public static String getConfirmPasswordField() {
		return adminProps.getProperty("confirmpassword_textbox");
	}
	public static String getsaveButton() {
		return adminProps.getProperty("save_button");
	}
	public static String getUserFullName(String fullname) {
		return adminProps.getProperty("userfullname").replace("xxxxx", fullname);
	}
	public static String getSearchById() {
		return adminProps.getProperty("search_by_id_textbox");
	}
	public static String getSearchByEmployeeName() {
		return adminProps.getProperty("search_by_employeename_textbox");
	}
	public static String getEmployeeIdInSearchList(String id) {
		return adminProps.getProperty("employeeid_after_search").replace("xxxxx", id);
	}
	public static String getEmployeeNameInSearchList(String employeename) {
		return adminProps.getProperty("employeename_after_search").replace("xxxxx", employeename);
	}
	public static String getSearchButton() {
		return adminProps.getProperty("search_button");
	}
	
	
	//Actions
	public boolean clickOnAdminMenu(WebDriver driver, String menuName) {
		driver.findElement(By.xpath(getAdminMenuLinks(menuName))).click();
		System.out.println("click on Admin Menu "+menuName);
		return true;
	}
	public boolean clickOnPIMMenu(WebDriver driver, String menuName) {
		commanutil.isElementPresentAndClickable(driver, getPasswordField(menuName));
		driver.findElement(By.xpath(getPasswordField(menuName))).click();
		System.out.println("click on PIM Menu "+menuName);
		return true;
	}
	
	//click button
	public boolean clickOnSaveButton(WebDriver driver) {
		driver.findElement(By.xpath(getsaveButton())).click();
		System.out.println("click on save button.... ");
		return true;
	}
	public boolean clickOnSearchButton(WebDriver driver) {
		driver.findElement(By.xpath(getSearchButton())).click();
		System.out.println("click on Search button.... ");
		return true;
	}
	
	
	//checkbox
	public boolean clickOnCreateNewLogin(WebDriver driver) {
		driver.findElement(By.xpath(getCreateLoginCheckbox())).click();
		System.out.println("click on create new login.... ");
		return true;
	}
	
	//entering into textbox
	public boolean enterFirstName(WebDriver driver, String firstName) {
		driver.findElement(By.xpath(getFirstNameField())).sendKeys(firstName);
		System.out.println("Entering Firstname....");
		return true;
	}
	public boolean enterMiddleName(WebDriver driver, String middleName) {
		driver.findElement(By.xpath(getMiddleNameField())).sendKeys(middleName);
		System.out.println("Entering Middlename");
		return true;
	}
	public boolean enterLastName(WebDriver driver, String lastName) {
		driver.findElement(By.xpath(getLastNameField())).sendKeys(lastName);
		System.out.println("Entering LastName.... ");
		return true;
	}
	public boolean enterEmployeeId(WebDriver driver, String id) {
		driver.findElement(By.xpath(getEmployeeIdField())).clear();
		driver.findElement(By.xpath(getEmployeeIdField())).sendKeys(id);
		System.out.println("Entering LastName.... ");
		return true;
	}
	
	public boolean enterUserName(WebDriver driver, String username) {
		driver.findElement(By.xpath(getUsernameField())).sendKeys(username);
		System.out.println("Entering Username.... ");
		return true;
	}
	public boolean enterPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(getPasswordField())).sendKeys(password);
		System.out.println("Entering Password.... ");
		return true;
	}
	public boolean enterConfirmPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(getConfirmPasswordField())).sendKeys(password);
		System.out.println("Entering ConfirmPassword.... ");
		return true;
	}
	public boolean enterIdToSearch(WebDriver driver, String id) {
		driver.findElement(By.xpath(getSearchById())).sendKeys(id);
		System.out.println("Entering Id.... ");
		return true;
	}
	public boolean enterEmployeeNameToSearch(WebDriver driver, String employeename) {
		driver.findElement(By.xpath(getSearchByEmployeeName())).sendKeys(employeename);
		System.out.println("Entering EmployeeName.... ");
		return true;
	}
	public boolean uploadEmployeePhotograph(WebDriver driver, String path) {
		driver.findElement(By.xpath(getPhotographFile())).sendKeys(path);
		System.out.println("uploading photograph.... ");
		return true;
	}
	
	
	//is element display
	public boolean isFullNameDispaly(WebDriver driver, String fullName) {
		boolean isDisplayed = false;
		commanutil.isElementVisible(driver, getUserFullName(fullName));
		isDisplayed = CommanUtils.isDisplayed(driver, getUserFullName(fullName));
		System.out.println("Is User created :" +isDisplayed);
		return isDisplayed;
	}
	public boolean isEmployeeIdDispaly(WebDriver driver, String id) {
		boolean isDisplayed = false;
		commanutil.isElementVisible(driver, getEmployeeIdInSearchList(id));
		isDisplayed = CommanUtils.isDisplayed(driver, getEmployeeIdInSearchList(id));
		System.out.println("Is User Id Found :" +isDisplayed);
		return isDisplayed;
	}
	public boolean isEmployeeNameDispaly(WebDriver driver, String employeeName) {
		boolean isDisplayed = false;
		commanutil.isElementVisible(driver, getEmployeeNameInSearchList(employeeName));
		isDisplayed = CommanUtils.isDisplayed(driver, getEmployeeNameInSearchList(employeeName));
		System.out.println("Is Employee Name Found :" +isDisplayed);
		return isDisplayed;
	}
	
	
}
