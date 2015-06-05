package com.cisco.acisizing.acisizing.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthConfiguration {
	
	private Map<String,String> authMap;
	
	public AuthConfiguration() {
		setAuthMap(new HashMap<String, String>());
	}

	public Map<String,String> getAuthMap() {
		return authMap;
	}

	public void setAuthMap(Map<String,String> authMap) {
			this.authMap = authMap;
	}
}
