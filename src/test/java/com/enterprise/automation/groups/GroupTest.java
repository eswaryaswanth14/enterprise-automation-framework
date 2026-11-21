package com.enterprise.automation.groups;

import org.testng.annotations.Test;

public class GroupTest {

	@Test(groups="smoke")
	public void loginTest() {
		System.out.println("smoke test executed");
	}
	@Test(groups="regression")
	public void invalidLogin() {
		System.out.println("Regression test executed");
	}
	@Test(groups="regression")
	public void forgotPassword() {
		System.out.println("Forgot password Test executed");
	}
	@Test(groups= {"regression","slow"})
	public void slowTest() {
		System.out.println("slow test executed");
	}

}
