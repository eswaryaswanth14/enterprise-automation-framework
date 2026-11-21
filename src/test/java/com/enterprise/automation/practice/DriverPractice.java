package com.enterprise.automation.practice;

import org.openqa.selenium.WebDriver;

import com.enterprise.automation.driver.DriverFactory;

public class DriverPractice {

	public static void main(String[] args) {
		WebDriver driver=DriverFactory.createDriver();
		driver.get("https://www.google.com/");
		System.out.println("PageTitle:"+driver.getTitle());
		driver.quit();
	}

}
