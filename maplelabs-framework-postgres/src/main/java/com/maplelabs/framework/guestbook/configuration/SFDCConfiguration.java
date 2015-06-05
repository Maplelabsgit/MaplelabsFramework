package com.maplelabs.framework.guestbook.configuration;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SFDCConfiguration {
	private String clientId;
	
	private String clientSecret;
	
	private String loginEndPointUrl;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getLoginEndPointUrl() {
		return loginEndPointUrl;
	}

	public void setLoginEndPointUrl(String loginEndPointUrl) {
		this.loginEndPointUrl = loginEndPointUrl;
	}
	
}
