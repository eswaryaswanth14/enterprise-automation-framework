package com.enterprise.automation.groups;

import org.testng.annotations.Test;

import com.enterprise.automation.driver.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

public class ParameterTest {
	
//	@Parameters("browser")
//	@Test
//	public void browserTest(String browserName) {
//		System.out.println("browser name:"+browserName);
//	}
	
	 @Parameters("browser")
	    @Test
	    public void browserTest(String browserName) {

	        WebDriver driver = DriverFactory.createDriver(browserName);

	        System.out.println("Browser launched: " + browserName);

	        driver.quit();
	    }

}
