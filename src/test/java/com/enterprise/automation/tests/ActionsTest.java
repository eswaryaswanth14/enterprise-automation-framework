package com.enterprise.automation.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.enterprise.automation.base.BaseTest;

public class ActionsTest extends BaseTest {
	
	@Test
	public void mouseHoverTest() {
		Actions a=new Actions(driver);
		driver.get("https://demoqa.com/menu");
	}

}
