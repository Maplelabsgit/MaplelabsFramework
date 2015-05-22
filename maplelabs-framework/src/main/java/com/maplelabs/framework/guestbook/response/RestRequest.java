package com.maplelabs.framework.guestbook.response;

public class RestRequest<T> {
	
	public T data;
	
	public RestRequest(T input) {
		data = input;
	}
}
