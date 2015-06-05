package com.cisco.acisizing.acisizing.rest.lookup;

import org.springframework.beans.BeansException;

import com.cisco.acisizing.acisizing.configuration.ConfigurationManager;
import com.cisco.acisizing.acisizing.rest.processor.RestProcessor;

public class RestLookUp {
	
	@SuppressWarnings("rawtypes")
	public RestProcessor getService(String serviceType) throws BeansException, ClassNotFoundException {
		RestProcessor service = null;

		String className = ConfigurationManager.getInstance().getRestConfiguration().getRestConfigMap().get(serviceType);
		if (className != null && !className.isEmpty()) {
			service = (RestProcessor) ConfigurationManager.getInstance()
					.getConfiguration().getApplicationContext()
					.getBean(Class.forName(className));
		}

		return service;
	}
}
