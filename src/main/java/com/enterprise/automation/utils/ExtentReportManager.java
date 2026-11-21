package com.enterprise.automation.utils;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	private static ExtentReports extent;
	private static ExtentSparkReporter spark;
	private static ExtentTest test;

	public static void initializeReport() {
		String path=System.getProperty("user.dir")+"/test-output/AutomationReport.html";
		new File(System.getProperty("user.dir")+"/test-output").mkdirs();
		
		spark=new ExtentSparkReporter(path);
		extent=new ExtentReports();
		extent.attachReporter(spark);
		spark.config().setReportName("Automation Test Execution Report");
		spark.config().setDocumentTitle("Automation Execution Results");
		spark.config().setTheme(Theme.STANDARD);
		extent.setSystemInfo("Project","Enterprise Automation Framework");
	}
	public static ExtentTest createTest(String testName) {
		test=extent.createTest(testName);
		return test;
	}
	public static void flushReport() {
		extent.flush();
	}
	public static void logPass(String message) {
		test.pass(message);
	}
	public static void logFail(String message) {
		test.fail(message);
		
	}
	public static void addScreenshot(String screenShotPath) throws IOException{
		test.addScreenCaptureFromPath(screenShotPath);
	}


}
