//package com.enterprise.automation.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class MenuPage {
//	WebDriver driver;
//	
//	public MenuPage(WebDriver driver) {
//		this.driver=driver;
//		 PageFactory.initElements(driver, this);
//	}
//	
//	@FindBy(xpath="//a[text()='Main Item 2']")
//	WebElement mainItem2;
//	Actions a=new Actions(driver);
//	
//	@FindBy()
//	
//	//MouseHover
//	public void hoverTest() {
//		a.moveToElement(mainItem2).perform();
//		a.contextClick(mainItem2).perform();
//		a.doubleClick().perform();
//		
//	}
//	//Right Click
//	public void rightClick() {
//		
//	}
//	
//
//}
