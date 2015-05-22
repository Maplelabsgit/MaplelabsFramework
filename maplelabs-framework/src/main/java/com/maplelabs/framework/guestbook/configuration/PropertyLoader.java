package com.maplelabs.framework.guestbook.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

	public static Properties loadproperties(String file) {
		Properties properties = new Properties();
		InputStream input = null;
	 
		try {
	 
			input = new FileInputStream(file);
	 
			// load a properties file
			properties.load(input);
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return properties;
	}
}
