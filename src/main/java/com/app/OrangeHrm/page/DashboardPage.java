package com.app.OrangeHrm.page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.app.OrangeHrm.constants.UiResourcePath;
import com.app.OrangeHrm.utils.CommanUtils;
import com.app.OrangeHrm.utils.PropertisUtil;

public class DashboardPage {
	
	static Properties dashBoard = PropertisUtil.loadProperty(UiResourcePath.DASHBOARD_PAGE);
	CommanUtils commanUtil = new CommanUtils();
	
	//all getters
	public static String getAssignLeave() {
		return dashBoard.getProperty("assign_leave");
	}
	public static String getEmployeeNameField() {
		return dashBoard.getProperty("employeename_textbox");
	}
	public static String getLeaveTypeDropdown() {
		return dashBoard.getProperty("leave_type_dropdown");
	}
	public static String getAssignDateFrom() {
		return dashBoard.getProperty("assigndate_from");
	}
	public static String getAssignDateFromPicker(String date) {
		return dashBoard.getProperty("from_to_date").replace("xxxxx", date);
	}
	public static String getAssignDateTo() {
		return dashBoard.getProperty("assigndate_to");
	}
	public static String getAssignDateToPicker(String date) {
		return dashBoard.getProperty("from_to_date").replace("xxxxx", date);
	}
	public static String getAssignButton() {
		return dashBoard.getProperty("assign_button");
	}
	public static String getAssignLeaveSuccessfullMessage() {
		return dashBoard.getProperty("assign_leave_successfull_message");
	}
	public static String getConfirmButton() {
		return dashBoard.getProperty("confirm_ok_button");
	}
	public static String getLeaveList() {
		return dashBoard.getProperty("assign_leave");
	}
	public static String getAllLeaveStatusCheckbox() {
		return dashBoard.getProperty("show_all_leave_status_checkbox");
	}
	public static String getEmployeenameForsearchLeaveListTextbox() {
		return dashBoard.getProperty("search_employeename_textbox");
	}
	public static String getSearchButton() {
		return dashBoard.getProperty("saecrh_employee_button");
	}
	public static String getEmployeeNameSearchresult(String employeeName) {
		return dashBoard.getProperty("employee_search_result").replace("xxxxx", employeeName);
	}
	
	
	//All Action
	//click action
	public boolean clickOnAssignLeave(WebDriver driver) {
		driver.findElement(By.xpath(getAssignLeave())).click();
		System.out.println("Click on assign leave....");
		return true;
	}
	public boolean clickOnAssignButton(WebDriver driver) {
		boolean isClick = false;
		if(commanUtil.isElementPresentAndClickable(driver, getAssignButton())) {
			driver.findElement(By.xpath(getAssignButton())).click();
			isClick = true;
		}
		System.out.println("Click on assign button: "+isClick);
		return isClick;
	}
	public boolean clickOnConfirmButton(WebDriver driver) {
		if(commanUtil.isElementPresentAndClickable(driver, getConfirmButton()))
			driver.findElement(By.xpath(getConfirmButton())).click();
		System.out.println("Click on confirm button....");
		return true;
	}
	public boolean clickOnLeaveList(WebDriver driver) {
		driver.findElement(By.xpath(getLeaveList())).click();
		System.out.println("Click on leave list....");
		return true;
	}
	public boolean clickOnSearchButton(WebDriver driver) {
		driver.findElement(By.xpath(getSearchButton())).click();
		System.out.println("Click on search button....");
		return true;
	}
	
	
	//checkbox or radiobutton
	public boolean clickOnStatusCheckbox(WebDriver driver) {
		driver.findElement(By.xpath(getAllLeaveStatusCheckbox())).click();
		System.out.println("Click on show all status checkbox....");
		return true;
	}
	
	
	//entering into textfield
	public boolean enterEmployeeName(WebDriver driver, String employeeName) {
		driver.findElement(By.xpath(getEmployeeNameField())).sendKeys(employeeName+Keys.ENTER);
		System.out.println("Entering employeename: "+employeeName);
		return true;
	}
	public boolean enterEmployeeNameForSearchLaeveList(WebDriver driver, String employeeName) {
		driver.findElement(By.xpath(getEmployeenameForsearchLeaveListTextbox())).sendKeys(employeeName+Keys.ENTER);
		System.out.println("Entering employeename: "+employeeName);
		return true;
	}
	
	//selecting dropdown
	public boolean selectLeaveType(WebDriver driver, String leaveType) {
		commanUtil.selectByVisibleText(driver, getLeaveTypeDropdown(), leaveType);
		System.out.println("Selecting vacation type: "+leaveType);
		return true;
	}
	
	public boolean selectFromDate(WebDriver driver, String date) {
		driver.findElement(By.xpath(getAssignDateFrom())).click();
		driver.findElement(By.xpath(getAssignDateFromPicker(date))).click();
		System.out.println("Selecting Date From: "+date);
		return true;
	}
	
	public boolean selectToDate(WebDriver driver, String date) {
		if(commanUtil.isElementVisible(driver, getAssignDateTo())) {
			driver.findElement(By.xpath(getAssignDateTo())).click();
			driver.findElement(By.xpath(getAssignDateFromPicker(date))).click();
		}
		System.out.println("Selecting Date to: "+date);
		return true;
	}

	//isDisplay methods
	public boolean isAssginLeaveMessageDisplay(WebDriver driver) {
		boolean isDisplay = false;
		isDisplay = commanUtil.isElementVisible(driver, getAssignLeaveSuccessfullMessage());
		//isDisplay = commanUtil.isDisplayed(driver, getAssignLeaveSuccessfullMessage());
		System.out.println("Assign leave message display: "+isDisplay);
		return isDisplay;
	}
	public boolean isEMployeeNameInSearchListDisplay(WebDriver driver, String employeeName) {
		boolean isDisplay = false;
		isDisplay = commanUtil.isElementVisible(driver, getEmployeeNameSearchresult(employeeName));
		System.out.println("Employee name display in search result: "+isDisplay);
		return isDisplay;
	}

}
