package com.cisco.acisizing.acisizing.constants;

public class GuestBookConstants {
	
	public static final String APP_HOME_DIR = System.getProperty("user.dir");
	
	public static final String SPRING_BOOT_CONFIG_FILE = APP_HOME_DIR + "/src/main/resources/application.properties";
	
	public static final String APP_CONFIG_DIR = APP_HOME_DIR + "/src/main/resources/config/";
	
	public static final String AUTH_CONFIG_FILE = APP_CONFIG_DIR + "auth-config.properties";
	
	public static final String REST_CONFIG_FILE = APP_CONFIG_DIR + "rest-config.properties";
	
	public static final String FORCE_CONFIG_FILE = APP_CONFIG_DIR + "force-config.properties";
	
	public static final String DB_UPGRADE_FILE = APP_CONFIG_DIR + "db-upgrade.properties";

	public static final String APP_SQL_DIR = APP_HOME_DIR + "/src/main/resources/sql/";
}
