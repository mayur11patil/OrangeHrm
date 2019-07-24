package com.app.OrangeHrm.Ui.Selenium;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.app.OrangeHrm.Ui.SelniumInterface.IDistributionManagement;


public class RunModeFactory {

	public enum RunMode {
		local, grid, browserstack, browserstacklocal, saucelabs;
	}

	public IDistributionManagement getRunMode(String runMode, String os, String osVersion, String browser,
			String browserVersion) {
		String enableLocalTesting = null;
		if (runMode.equals("browserstack"))
			enableLocalTesting = "false";
		else if (runMode.equals("browserstacklocal"))
			enableLocalTesting = "true";

		switch (RunMode.valueOf(runMode)) {
		case local:
			return new RunModeLocal(browser);
		
		default:
			return null;
		}
	}

		}


