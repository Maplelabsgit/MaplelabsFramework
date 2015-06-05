package com.cisco.acisizing.acisizing.rest.processor;

import com.cisco.acisizing.acisizing.response.RestRequest;

public abstract class RestProcessor<T> {
	
	protected RestRequest request = null; 
	protected T result = null;
	
	protected void preProcess() {
		
	}
	
	protected abstract void doProcess();
	
	protected void postProcess() {
		
	}
	
	public T execute() {
		
		preProcess();
		doProcess();
		postProcess();
		
		return result;
	}

	public RestRequest getRequest() {
		return request;
	}

	public void setRequest(RestRequest request) {
		this.request = request;
	}
	
}
