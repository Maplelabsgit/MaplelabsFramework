package com.cisco.acisizing.acisizing.authenticator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.acisizing.force.api.ApiConfig;
import com.cisco.acisizing.force.api.ApiSession;
import com.cisco.acisizing.force.api.ApiVersion;
import com.cisco.acisizing.force.api.Auth;
import com.cisco.acisizing.acisizing.configuration.ConfigurationManager;
import com.cisco.acisizing.acisizing.configuration.SFDCConfiguration;
import com.cisco.acisizing.acisizing.domain.User;
import com.cisco.acisizing.acisizing.service.UserService;

@Component("sfdcAuthenticator")
public class SFDCAuthenticator extends AbstractAuthenticator {

	@Autowired
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User authenticate(String username, String password) {

		boolean isAuthenticated = authenticateSFDC(username, password);

		User domain = null;

		try {
			if (isAuthenticated) {
				domain = userService.findUserByName(username);

				if (domain == null) {
					domain = new User();

					domain.setUsername(username);
					domain.setEmailAddress(username);
					userService.createUser(domain);

					domain = userService.findUserByName(domain.getUsername());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return domain;
	}

	private boolean authenticateSFDC(String username, String password) {
		boolean result = false;

		SFDCConfiguration sfdcConfiguration = ConfigurationManager
				.getInstance().getSfdcConfiguration();

		ApiConfig apiConfig = new ApiConfig();
		apiConfig.setApiVersion(ApiVersion.DEFAULT_VERSION);
		apiConfig.setClientId(sfdcConfiguration.getClientId());
		apiConfig.setClientSecret(sfdcConfiguration.getClientSecret());
		apiConfig.setLoginEndpoint(sfdcConfiguration.getLoginEndPointUrl());
		apiConfig.setUsername(username);
		apiConfig.setPassword(password);

		ApiSession apiSession = Auth.authenticate(apiConfig);

		if (apiSession != null && !apiSession.getAccessToken().isEmpty()) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

}
