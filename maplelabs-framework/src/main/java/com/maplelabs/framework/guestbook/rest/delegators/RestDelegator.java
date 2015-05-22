package com.maplelabs.framework.guestbook.rest.delegators;

import javax.ws.rs.core.Response;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

import com.maplelabs.framework.guestbook.response.RestRequest;
import com.maplelabs.framework.guestbook.rest.lookup.RestLookUp;
import com.maplelabs.framework.guestbook.rest.processor.RestProcessor;
@Component("restDelegator")
public class RestDelegator {
	
	private Response response = null;
	private RestRequest request = null;

	private RestLookUp lookupService = new RestLookUp();
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

	public RestRequest getRequest() {
		return request;
	}

	public void setRequest(RestRequest request) {
		this.request = request;
	}
}
