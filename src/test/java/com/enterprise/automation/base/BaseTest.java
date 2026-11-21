package com.enterprise.automation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.enterprise.automation.utils.Log;
import com.enterprise.automation.utils.ConfigReader;
import com.enterprise.automation.driver.DriverManager;
import com.enterprise.automation.driver.DriverFactory;

public class BaseTest {

	protected WebDriver driver;
	@BeforeMethod
	public void setup() {
		Log.info("Browser Started");
		//		driver=DriverFactory.createDriver();
		//		driver.get(ConfigReader.getProperty("url"));

		DriverManager.setDriver(driver=DriverFactory.createDriver());
		driver=DriverManager.getDriver();
		driver.get(ConfigReader.getProperty("url"));
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		//		if(driver!=null) {
		//			driver.quit();
		//		}
//		if(DriverManager.getDriver()!=null) {
//			DriverManager.getDriver().quit();
//			DriverManager.unload();
//		}
		 WebDriver currentDriver = DriverManager.getDriver();
		 try {
			 if(currentDriver!=null) {
				 currentDriver.quit();
			 }
		 }
		 finally {
			  DriverManager.unload();
		 }
		Log.info("Browser closed successfully");
	}
//	public WebDriver getDriver() {
//		return driver;
//	}

	public WebDriver getDriver() {
	    return DriverManager.getDriver();
	}
}
