package com.enterprise.automation.utils;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class ConfigReader {
	private static Properties p=new Properties();
	
	static {
		try {
			InputStream input=ConfigReader.class.getClassLoader()
					.getResourceAsStream("config.properties");
			
			if (input == null) {
			    throw new RuntimeException("config.properties file not found");
			}
			p.load(input);
		}
		catch(IOException e) {
		    throw new RuntimeException("Unable to load config.properties", e);
		}
	}
	public static String getProperty(String key) {
		return p.getProperty(key);
	}
	
	
	

}
