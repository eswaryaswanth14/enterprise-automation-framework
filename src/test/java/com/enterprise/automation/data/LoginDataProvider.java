package com.enterprise.automation.data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

	@DataProvider(name="loginData")
	public Object[][] getLoginData(){
		return new Object[][]{
			{"Admin","admin123","SUCCESS"},
			{"Admin","Wrong123","Invalid credentials"},
			{"Wronguser","admin123","Invalid credentials"}
		};
	}
}