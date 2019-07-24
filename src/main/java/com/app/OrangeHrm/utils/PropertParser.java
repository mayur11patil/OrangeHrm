package com.app.OrangeHrm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertParser {
	
	public static ResourceBundle applicationResource = ResourceBundle.getBundle("com.app.OrangeHrm.TestSuite.config");
	
	/**
	 * This method load all the property values
	 * depends on provided file path and returns the loaded property values 
	 * @param filePath
	 * @return property list
	 * @throws IOException
	 */
	public Properties loadProperty(String filePath) throws IOException{
		Properties props = new Properties();
		FileInputStream ip = new FileInputStream(filePath);
		props.load(ip);
		return props;
	}
	
	public static String readEnvOrConfigProperty(String key) {
        // first pref for env, next for config file
        String value = System.getProperty(key);
        if (value == null || value.trim().length() == 0) {
            value = applicationResource.getString(key);
        }
        return value;
    }

}


