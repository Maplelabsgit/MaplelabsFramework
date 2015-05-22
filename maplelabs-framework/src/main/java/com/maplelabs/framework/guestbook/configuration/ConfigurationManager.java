package com.maplelabs.framework.guestbook.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import scala.annotation.cloneable;

import com.maplelabs.framework.guestbook.constants.GuestBookConstants;

public class ConfigurationManager {

	private static ConfigurationManager configurationManager = null;

	private Configuration configuration;

	private AuthConfiguration authConfiguration;

	private RestConfiguration restConfiguration;

	private ConfigurationManager() {
		configuration = new Configuration();
		authConfiguration = new AuthConfiguration();
		restConfiguration = new RestConfiguration();
	}

	public static ConfigurationManager getInstance() {

		if (configurationManager == null) {
			synchronized (ConfigurationManager.class) {
				if (configurationManager == null) {
					configurationManager = new ConfigurationManager();
					configurationManager.loadConfigurations();
				}
			}
		}

		return configurationManager;
	}

	private void loadConfigurations() {
		loadAuthConfiguration();
		loadRestConfiguration();
	}

	private void loadAuthConfiguration() {

		Properties properties = PropertyLoader
				.loadproperties(GuestBookConstants.AUTH_CONFIG_FILE);

		Map<String, String> authMap = new HashMap<String, String>();

		for (String name : properties.stringPropertyNames()) {
			System.out.println(name + " " + properties.getProperty(name));
			authMap.put(name, properties.getProperty(name));
		}

		authConfiguration.setAuthMap(authMap);

	}

	private void loadRestConfiguration() {

		Properties properties = PropertyLoader
				.loadproperties(GuestBookConstants.REST_CONFIG_FILE);

		Map<String, String> restMap = new HashMap<String, String>();

		for (String name : properties.stringPropertyNames()) {
			System.out.println(name + " " + properties.getProperty(name));
			restMap.put(name, properties.getProperty(name));
		}

		restConfiguration.setRestConfigMap(restMap);

	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public AuthConfiguration getAuthConfiguration() {
		return authConfiguration;
	}

	public void setAuthConfiguration(AuthConfiguration authConfiguration) {
		this.authConfiguration = authConfiguration;
	}

	public RestConfiguration getRestConfiguration() {
		return restConfiguration;
	}

	public void setRestConfiguration(RestConfiguration restConfiguration) {
		this.restConfiguration = restConfiguration;
	}
}
