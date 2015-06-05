package com.maplelabs.framework.guestbook.authenticator;


public abstract class AbstractAuthenticator {
	
	public abstract Object authenticate(String username, String password);
	
}
