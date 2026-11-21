package com.enterprise.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.enterprise.automation.base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="username")
	private WebElement userName;
	@FindBy(name="password")
	private WebElement passWord;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement invalid;
	@FindBy(xpath="//span[text()='Required']")
	private WebElement passwordRequired;
	@FindBy(xpath="//span[text()='Required']")
	private WebElement userNameRequired;

	public void enterUserName(String username) {
		enterText(userName,username);
	}
	public void enterPassword(String password) {
		enterText(passWord,password);
	}
	public void clickLogin() {
		click(login);
	}
	public String  getErrorMessage() {
		return getText(invalid);
	}
	public String getPasswordMessage() {
		return passwordRequired.getText();
	}
	public String getUserMessage() {
		return userNameRequired.getText();
	}
	public void login(String userNAme,String password) {
		enterUserName(userNAme);
		enterPassword(password);
		clickLogin();
	}



}
