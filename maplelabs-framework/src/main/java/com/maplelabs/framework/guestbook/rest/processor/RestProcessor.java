package com.maplelabs.framework.guestbook.rest.processor;


public abstract class RestProcessor<T> {
	
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
}
