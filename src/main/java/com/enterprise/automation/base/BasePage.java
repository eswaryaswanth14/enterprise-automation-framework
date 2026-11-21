package com.enterprise.automation.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.enterprise.automation.utils.WaitUtils;

public class BasePage {

	protected WebDriver driver;

	private WaitUtils waitUtils;

	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.waitUtils=new WaitUtils(driver);
	}
	public void click(By locator) {
		waitUtils.waitForClickable(locator);
		driver.findElement(locator).click();
	}
	public void enterText(By locator,String text) {
		waitUtils.waitForVisibility(locator);
		driver.findElement(locator).sendKeys(text);
	}
	public String getText(By locator) {
		waitUtils.waitForVisibility(locator);
		return driver.findElement(locator).getText();
	}
	public boolean isDisplayed(By locator) {
		waitUtils.waitForVisibility(locator);
		return driver.findElement(locator).isDisplayed();
	}
	public void click(WebElement element) {
	    waitUtils.waitForClickable(element);
	    element.click();
	}

	public void enterText(WebElement element, String text) {
	    waitUtils.waitForVisibility(element);
	    element.sendKeys(text);
	}
	public boolean isDisplayed(WebElement element) {
		waitUtils.waitForVisibility(element);
		return element.isDisplayed();
	}
	public String getText(WebElement element) {
		waitUtils.waitForVisibility(element);
		return element.getText();
	}

}