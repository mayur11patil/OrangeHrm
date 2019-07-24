package com.app.OrangeHrm.helpers;

import org.openqa.selenium.WebDriver;

import com.app.OrangeHrm.constants.UiResourcePath;
import com.app.OrangeHrm.page.AdminPage;

public class AdminHelpers {

	
	AdminPage adminPage = new AdminPage();
	
	public boolean navigateToAddEmployee(WebDriver driver) {
		boolean navigate = false;
		if(adminPage.clickOnAdminMenu(driver, "PIM"))
			if(adminPage.clickOnPIMMenu(driver, "Add Employee"))
				navigate = true;
		return navigate;
	}
	
	public boolean navigateToEmployeeList(WebDriver driver) {
		boolean navigate = false;
		if(adminPage.clickOnAdminMenu(driver, "PIM"))
			if(adminPage.clickOnPIMMenu(driver, "Employee List"))
				navigate = true;
		return navigate;
	}
	
	public boolean addEmployeeDetails(WebDriver driver) {
		String firstName= "Mayur";
		String middleName="Ramdas";
		String lastName="Patil";
		String id="2244";
		String userName="kkmm.patil";
		String password="mayur1234";
		String confirmPassword="mayur1234";
		
		adminPage.enterFirstName(driver, firstName);
		adminPage.enterMiddleName(driver, middleName);
		adminPage.enterLastName(driver, lastName);
		adminPage.enterEmployeeId(driver, id);
		adminPage.uploadEmployeePhotograph(driver, UiResourcePath.PROFILE_PHTO_PATH);
		adminPage.clickOnCreateNewLogin(driver);
		adminPage.enterUserName(driver, userName);
		adminPage.enterPassword(driver, password);
		adminPage.enterConfirmPassword(driver, confirmPassword);
		adminPage.clickOnSaveButton(driver);
		
		return adminPage.isFullNameDispaly(driver, firstName);
	}
	
	public boolean searchById(WebDriver driver) {
		String id="2222";
		adminPage.enterIdToSearch(driver, id);
		adminPage.clickOnSearchButton(driver);
		return adminPage.isEmployeeIdDispaly(driver, id);
	}
	
	public boolean searchByEmployeeName(WebDriver driver) {
		String employeeName="Mayur Ramdas";
		adminPage.enterEmployeeNameToSearch(driver, employeeName);
		adminPage.clickOnSearchButton(driver);
		return adminPage.isEmployeeNameDispaly(driver, employeeName);
	}
}
