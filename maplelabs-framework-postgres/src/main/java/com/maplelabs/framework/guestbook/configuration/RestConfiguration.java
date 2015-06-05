package com.maplelabs.framework.guestbook.configuration;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestConfiguration {

	private Map<String,String> restConfigMap;

	public Map<String,String> getRestConfigMap() {
		return restConfigMap;
	}

	public void setRestConfigMap(Map<String,String> restConfigMap) {
		this.restConfigMap = restConfigMap;
	}
}
