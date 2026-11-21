package com.enterprise.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

	WebDriver driver;
	public JavaScriptUtils(WebDriver driver) {
		this.driver=driver;
	}
	JavascriptExecutor js= (JavascriptExecutor) driver;
	public void scrollDown() {

		js.executeScript("window.scrollBy(0,500)");
	}
	public void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	public void clickElement(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	
	public void highlightElement(WebElement element) {

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript(
	        "arguments[0].style.border='3px solid red';", element);
	}
	
}


