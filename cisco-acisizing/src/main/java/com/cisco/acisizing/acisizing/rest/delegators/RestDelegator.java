package com.cisco.acisizing.acisizing.rest.delegators;

import javax.ws.rs.core.Response;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

import com.cisco.acisizing.acisizing.response.RestRequest;
import com.cisco.acisizing.acisizing.rest.lookup.RestLookUp;
import com.cisco.acisizing.acisizing.rest.processor.RestProcessor;
@Component("restDelegator")
public class RestDelegator {
	
	private Response response = null;
	@SuppressWarnings("rawtypes")
	private RestRequest request = null;

	private RestLookUp lookupService = new RestLookUp();
	@SuppressWarnings("rawtypes")
	private RestProcessor restService;
	private String serviceType;
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void executeService() throws BeansException, ClassNotFoundException {
		getService();
		response = Response.ok(restService.execute()).build();
	}
	
	private void getService() throws BeansException, ClassNotFoundException {
		restService = lookupService.getService(serviceType);
		restService.setRequest(request);
	}
	
	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	@SuppressWarnings("rawtypes")
	public RestRequest getRequest() {
		return request;
	}

	@SuppressWarnings("rawtypes")
	public void setRequest(RestRequest request) {
		this.request = request;
	}
}
