package com.enterprise.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.enterprise.automation.base.BaseTest;
import com.enterprise.automation.data.LoginDataProvider;
import com.enterprise.automation.pages.DashboardPage;
import com.enterprise.automation.pages.LoginPage;
import com.enterprise.automation.driver.DriverManager;

public class LoginTest extends BaseTest {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;

	
	@Test
	public void verifyLogin() {
//		loginPage=new LoginPage(driver);
		loginPage=new LoginPage(DriverManager.getDriver());
		loginPage.enterUserName("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickLogin();
//		dashboardPage=new DashboardPage(driver);
		dashboardPage=new DashboardPage(DriverManager.getDriver());
		Assert.assertTrue(dashboardPage.isDashBoardDisplayed(),"Dashboard not displayed");	
	}
	@Test
	public void invalidCredentails() {
//		loginPage=new LoginPage(driver);
		loginPage =new LoginPage(DriverManager.getDriver());
		loginPage.enterUserName("Admin");
		loginPage.enterPassword("Admin99");
		loginPage.clickLogin();
		String errorMessage=loginPage.getErrorMessage();
		Assert.assertEquals(errorMessage, "Invalid credentials","Incorrect error message displayed");
	}
	@Test
	public void emptyUserName() {
//		loginPage=new LoginPage(driver);
		loginPage=new LoginPage(DriverManager.getDriver());
		loginPage.enterUserName("");
		loginPage.enterPassword("admin123");
		loginPage.clickLogin();
		String userMessage=loginPage.getUserMessage();
		Assert.assertEquals(userMessage, "Required","Not displayed user error message");
	}
	@Test
	public void emptyPassword() {
//		loginPage=new LoginPage(driver);
		loginPage=new LoginPage(DriverManager.getDriver());
		loginPage.enterUserName("Admin");
		loginPage.enterPassword("");
		loginPage.clickLogin();
		String passwordMessage=loginPage.getPasswordMessage();
		Assert.assertEquals(passwordMessage, "Required","not displayed password message");
	}
	@Test(dataProvider="loginData",dataProviderClass=LoginDataProvider.class)
	public void multipleDataSets(String userName,String password,String expectedResult) {
//		loginPage=new LoginPage(driver);
		loginPage=new LoginPage(DriverManager.getDriver());
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		if(expectedResult.equals("SUCCESS")) {
//			 DashboardPage dashboardPage = new DashboardPage(driver);
			dashboardPage=new DashboardPage(DriverManager.getDriver());
			 Assert.assertTrue(dashboardPage.isDashBoardDisplayed(),"Dashboard not displayed");
			 
		}
		else {
			Assert.assertEquals(loginPage.getErrorMessage(), expectedResult,"incorrect error message");
		}
	}
	
//	@Test
//	public void screenshotFailureTest() {
//	    Assert.fail("Intentional failure to test screenshot capture");
//	}
	

}
