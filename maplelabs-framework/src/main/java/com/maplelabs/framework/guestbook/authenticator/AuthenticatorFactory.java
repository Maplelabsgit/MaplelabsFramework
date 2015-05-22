package com.maplelabs.framework.guestbook.authenticator;

import org.springframework.beans.BeansException;

import com.maplelabs.framework.guestbook.configuration.ConfigurationManager;

public class AuthenticatorFactory {

	public static ConfigurationManager configurationManager = ConfigurationManager
			.getInstance();

	public static AbstractAuthenticator getAuthenticator(String authType) throws BeansException, ClassNotFoundException {
		AbstractAuthenticator authenticator = null;

		String className = configurationManager.getAuthConfiguration().getAuthMap().get(authType);
		if (className != null && !className.isEmpty()) {
			authenticator = (AbstractAuthenticator) ConfigurationManager.getInstance()
					.getConfiguration().getApplicationContext()
					.getBean(Class.forName(className));
		}

		return authenticator;
	}
}
