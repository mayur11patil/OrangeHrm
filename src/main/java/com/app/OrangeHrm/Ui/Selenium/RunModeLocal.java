package com.app.OrangeHrm.Ui.Selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.app.OrangeHrm.Ui.Selenium.enums.BrowserType;
import com.app.OrangeHrm.Ui.SelniumInterface.IDistributionManagement;

public class RunModeLocal extends DriverManager implements IDistributionManagement {

	
	public RunModeLocal(String browser) {
		
		try
		{
		switch (BrowserType.valueOf(browser)) {
		case CHROME:{
				this.driver = setChromeDriver();
				System.out.println("Chrome driver set "+driver);
				break;
			}
		case FIREFOX:
				System.out.println("firefox case");
				this.driver = setFirefoxDriver();
				System.out.println("Firefox driver set "+driver);
				break;
			
		case IE:
				this.driver = setInterExplorerDriver();
				System.out.println("Internet driver set "+driver);
		default:
			break;
		}
		}
		catch(NullPointerException ne) {
			System.out.println("browser is null");
		}
		catch(Exception e) {
			
		}
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	private WebDriver setChromeDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		String os = System.getProperty("os.name");

		if (os.toLowerCase().contains("linux")) {
			System.setProperty("webdriver.chrome.driver", currentdir + "chromedriver");
		} else if (os.toLowerCase().contains("mac")) {
			System.setProperty("webdriver.chrome.driver", currentdir + "chromedriver");
		} else {
			System.out.println("windows os");
			System.setProperty("webdriver.chrome.driver", currentdir + "chromedriver.exe");
		}

		return new ChromeDriver();
	}
	
	private WebDriver setFirefoxDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		String os = System.getProperty("os.name");
		if (os.toLowerCase().contains("linux")) {
			System.setProperty("webdriver.gecko.driver", currentdir + "geckodriver");
		} else if (os.toLowerCase().contains("mac")) {
			System.setProperty("webdriver.gecko.driver", currentdir + "geckodriver");
		} else {
			System.out.println("window ");
			System.setProperty("webdriver.gecko.driver", currentdir + "geckodriver.exe");
		}

		return new FirefoxDriver();
	}
	
	public WebDriver setInterExplorerDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.ie.driver", currentdir + "IEDriverServer.exe");
		return new InternetExplorerDriver();
	}

}
