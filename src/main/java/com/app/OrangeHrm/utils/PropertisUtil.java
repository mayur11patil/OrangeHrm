package com.app.OrangeHrm.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertisUtil {
	
	public static Properties loadProperty(String propertiesFilePath) {
		Properties properties = new Properties();
		PropertParser propertyParser = new PropertParser();

		try {
			properties = propertyParser.loadProperty(propertiesFilePath);
		} catch (IOException ioException) {
			System.out.println("IOException occured as " + ioException.getMessage());
			return null;
		}

		return properties;
	}
}
