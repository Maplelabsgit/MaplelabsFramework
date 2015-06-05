package com.cisco.acisizing.acisizing.db.util;

import java.util.Properties;

import org.springframework.context.ApplicationContext;

import com.cisco.acisizing.acisizing.configuration.ConfigurationManager;
import com.cisco.acisizing.acisizing.configuration.PropertyLoader;
import com.cisco.acisizing.acisizing.constants.GuestBookConstants;


public class DBConnectionProps {
	
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	private String dbDriver;
	
	public DBConnectionProps() {
		loadDBProperties();
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	private void loadDBProperties() {
		ApplicationContext applicationContext = ConfigurationManager.getInstance().getConfiguration().getApplicationContext();
		
		dbUrl = applicationContext.getEnvironment().getProperty("spring.datasource.url");
		dbUsername = applicationContext.getEnvironment().getProperty("spring.datasource.username");
		dbPassword = applicationContext.getEnvironment().getProperty("spring.datasource.password");
		dbDriver = applicationContext.getEnvironment().getProperty("spring.datasource.driverClassName");
	}
}
