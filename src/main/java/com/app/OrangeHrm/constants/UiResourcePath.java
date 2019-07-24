package com.app.OrangeHrm.constants;

import java.io.File;

public class UiResourcePath {

	public static final String USER_HOME = System.getProperty("user.dir") + File.separator;
	public static final String RESOURCES_HOME = USER_HOME + "Resources" + File.separator;
	
	public static final String TESTDATA_HOME =  RESOURCES_HOME + "testdata" + File.separator;
	
	public static final String LOCATORS_HOME = RESOURCES_HOME + File.separator + "locators" + File.separator;
	
	public static String getTestDataFilePath() {
		String CS_TEST_DATA_FILE;
		CS_TEST_DATA_FILE = TESTDATA_HOME + "OrangeHrmTestData.xlsx";
		return CS_TEST_DATA_FILE;
	}
	
	/*
	 * properties file paths
	 */

	public static final String ADMIN_PAGE = LOCATORS_HOME + "admin.properties";
	public static final String LOGIN_PAGE = LOCATORS_HOME + "loginpage.properties";
	public static final String DASHBOARD_PAGE = LOCATORS_HOME + "dashboard.properties";
	
	
	/*
	 * Excel File Path
	 */
	
	public static final String TEST_DATA_ADMIN_SHEET="Admin_testData";
	
	
	/*
	 * Profile photo file path 
	 */
	
	public static final String PROFILE_PHTO_PATH = RESOURCES_HOME+"images"+File.separator+"profile.jpg";
	
}
