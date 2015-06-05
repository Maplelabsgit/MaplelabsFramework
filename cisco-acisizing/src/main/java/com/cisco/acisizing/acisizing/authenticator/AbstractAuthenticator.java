package com.cisco.acisizing.acisizing.authenticator;


public abstract class AbstractAuthenticator {
	
	public abstract Object authenticate(String username, String password);
	
}
