package com.maplelabs.framework.guestbook.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maplelabs.framework.guestbook.configuration.AuthConfiguration;
import com.maplelabs.framework.guestbook.configuration.ConfigurationManager;

@RestController
public class AppConfigurationController {
	
	@RequestMapping(value = "/Config/AuthConfig", method = RequestMethod.GET, produces = "application/json")
	public AuthConfiguration getAuthConfiguration() {

		return ConfigurationManager.getInstance().getAuthConfiguration();
	}
}
