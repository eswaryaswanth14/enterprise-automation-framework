package com.enterprise.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.enterprise.automation.listeners.RetryAnalyzer;

public class RetryTest {
	
	@Test(retryAnalyzer =RetryAnalyzer.class)
	public void retryTest() {
		System.out.println("Executing test");
		Assert.fail("Intentional failure for retry practice");
	}

}
