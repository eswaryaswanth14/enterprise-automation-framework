package com.enterprise.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.enterprise.automation.base.BasePage;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement dashboard;
	
	public boolean isDashBoardDisplayed() {
		return isDisplayed(dashboard);
	}

}
