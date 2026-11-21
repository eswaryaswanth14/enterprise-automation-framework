package com.enterprise.automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {


	public static String captureScreenshots(WebDriver driver,String testName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);

		String folderPath=System.getProperty("user.dir") + "/screenshots/";
		Files.createDirectories(Paths.get(folderPath));
		String dest=folderPath+testName+ ".png";
		FileUtils.copyFile(source, new File(dest));
		return dest;


	}

}
