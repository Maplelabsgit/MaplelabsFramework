package com.cisco.acisizing.acisizing.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.cisco.acisizing.acisizing.constants.GuestBookConstants;

public class ConfigurationManager {

	private static ConfigurationManager configurationManager = null;

	private Configuration configuration;

	private AuthConfiguration authConfiguration;

	private RestConfiguration restConfiguration;
	
	private SFDCConfiguration sfdcConfiguration;

	private ConfigurationManager() {
		configuration = new Configuration();
		authConfiguration = new AuthConfiguration();
		restConfiguration = new RestConfiguration();
		sfdcConfiguration = new SFDCConfiguration();
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
		loadSFDCConfiguration();
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
	
	private void loadSFDCConfiguration() {

		Properties properties = PropertyLoader
				.loadproperties(GuestBookConstants.FORCE_CONFIG_FILE);

		sfdcConfiguration.setClientId(properties.getProperty("clientId"));
		sfdcConfiguration.setClientSecret(properties.getProperty("clientSecret"));
		sfdcConfiguration.setLoginEndPointUrl(properties.getProperty("loginEndPointUrl"));

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

	public SFDCConfiguration getSfdcConfiguration() {
		return sfdcConfiguration;
	}

	public void setSfdcConfiguration(SFDCConfiguration sfdcConfiguration) {
		this.sfdcConfiguration = sfdcConfiguration;
	}
}
