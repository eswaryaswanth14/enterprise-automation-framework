package com.enterprise.automation.utils;
import com.enterprise.automation.utils.ConfigReader;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private WebDriverWait wait;

	public WaitUtils(WebDriver driver) {
		int timeout = Integer.parseInt(ConfigReader.getProperty("explicitWait"));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	}
	public void waitForVisibility(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void waitForClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}
	public void waitForInvisibility(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public void waitForPresence(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public void waitForVisibility(WebElement element) {
	    wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForClickable(WebElement element) {
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}


}
