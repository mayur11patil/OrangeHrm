package com.app.OrangeHrm.helpers;

import org.openqa.selenium.WebDriver;

import com.app.OrangeHrm.page.AdminPage;
import com.app.OrangeHrm.page.DashboardPage;

public class DashboardHelpers {

	DashboardPage dashboardPage = new DashboardPage();
	AdminPage adminPage = new AdminPage();
	
	public boolean assignLeave(WebDriver driver) {
		String menuName = "Assign Leave";
		String employeeName = "Linda Anderson";
		String leaveType = "Vacation US";
		String fromDate = "30";
		String toDate = "30";
		
		dashboardPage.clickOnAssignLeave(driver);
		adminPage.clickOnPIMMenu(driver, menuName);
		dashboardPage.enterEmployeeName(driver, employeeName);
		dashboardPage.selectLeaveType(driver, leaveType);
		dashboardPage.selectFromDate(driver, fromDate);
		dashboardPage.selectToDate(driver, toDate);
		dashboardPage.clickOnAssignButton(driver);
		dashboardPage.clickOnConfirmButton(driver);
		return dashboardPage.isAssginLeaveMessageDisplay(driver);
	}
	
	public boolean viewLeaveList(WebDriver driver) {
		String employeeName = "Linda Anderson";
		
		dashboardPage.clickOnLeaveList(driver);
		dashboardPage.enterEmployeeNameForSearchLaeveList(driver, employeeName);
		dashboardPage.clickOnStatusCheckbox(driver);
		dashboardPage.clickOnSearchButton(driver);
		
		return dashboardPage.isEMployeeNameInSearchListDisplay(driver, employeeName);
	}
}
