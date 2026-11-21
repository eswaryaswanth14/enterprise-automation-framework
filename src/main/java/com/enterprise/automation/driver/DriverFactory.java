package com.enterprise.automation.driver;
import com.enterprise.automation.utils.Log;
import com.enterprise.automation.utils.ConfigReader;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
	
	public static WebDriver createDriver() {
		Log.info("Starting browser");
		String browser = ConfigReader.getProperty("browser");
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
		    driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
		    driver = new EdgeDriver();
		}
		else {
		    throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		
		Log.info("Starting chrome driver");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Log.info("Browser launched successfully");
		return driver;
	}
	public static WebDriver createDriver(String browser) {
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
		    driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
		    driver = new EdgeDriver();
		}
		else {
		    throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
		
	}

}
