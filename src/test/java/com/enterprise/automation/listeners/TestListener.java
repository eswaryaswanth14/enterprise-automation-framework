package com.enterprise.automation.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.enterprise.automation.utils.Log;

import com.enterprise.automation.base.BaseTest;
import com.enterprise.automation.utils.ExtentReportManager;
import com.enterprise.automation.utils.ScreenshotUtils;

public class TestListener implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		Log.info("Test Started: " + result.getName());
		ExtentReportManager.createTest(result.getName());
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("Test Passed: " + result.getName());
		ExtentReportManager.logPass("Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		BaseTest testClass=(BaseTest)result.getInstance();
		WebDriver driver=testClass.getDriver();
		try {
			String path=ScreenshotUtils.captureScreenshots(driver,result.getName());
			ExtentReportManager.addScreenshot(path);
			System.out.println("ScreenShot saved:"+path);
		}
		catch(IOException e){
			e.printStackTrace();	
		}
		Log.error("Failure reason: " + result.getThrowable());
		Log.error("Test Failed: " + result.getName());
		
	}
	@Override
	public void onStart(ITestContext context) {
		ExtentReportManager.initializeReport();
	}
	@Override
	public void onFinish(ITestContext context) {
		ExtentReportManager.flushReport();
	}
	

}
