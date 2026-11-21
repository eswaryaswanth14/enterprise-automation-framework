package com.enterprise.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.enterprise.automation.base.BaseTest;
import com.enterprise.automation.data.ExcelLoginDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.enterprise.automation.driver.DriverFactory;
import com.enterprise.automation.pages.DashboardPage;
import com.enterprise.automation.pages.LoginPage;

public class ExcelDataProviderTest extends BaseTest{

	private LoginPage loginPage;

	@Test(dataProvider="excelLoginData",dataProviderClass=ExcelLoginDataProvider.class)
	public void loginTest(String userName,String password,String expectedResult) {
		System.out.println("UserName:"+userName);
		System.out.println("Password:"+password);
		System.out.println("ExpectedResult:"+expectedResult);
		loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
		if(expectedResult.equalsIgnoreCase("SUCCESS")) {
			DashboardPage d=new DashboardPage(driver);
			Assert.assertTrue(d.isDashBoardDisplayed(),"Dashboard not displayed");
		}
		//		else {
		//			Assert.assertEquals(loginPage.getErrorMessage(),"Invalid credentials","Incorrect error message");
		//		}
		else if(userName.isEmpty()) {
			Assert.assertEquals(loginPage.getUserMessage(),"Required","Username required message not displayed");

		}
		else {
			Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials",
					"Incorrect error message");
		}
	}

}
