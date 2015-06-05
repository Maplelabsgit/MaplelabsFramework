package com.cisco.acisizing.acisizing.configuration;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.ApplicationContext;

@XmlRootElement
public class Configuration {
	
	private ApplicationContext applicationContext;

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		if(this.applicationContext == null) {
			this.applicationContext = applicationContext;
		} 
	}
}
