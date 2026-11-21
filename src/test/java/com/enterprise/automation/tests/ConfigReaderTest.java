package com.enterprise.automation.tests;
import com.enterprise.automation.utils.ConfigReader;	

public class ConfigReaderTest {
	public static void main(String[] args) {
		String browser=ConfigReader.getProperty("browser");
		System.out.println("Browser:"+browser);
		String url = ConfigReader.getProperty("url");
		System.out.println("URL: " + url);
	}
	

}
