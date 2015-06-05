package com.cisco.acisizing.acisizing.response;

public class RestRequest<T> {
	
	public T data;
	
	public RestRequest(T input) {
		data = input;
	}
}
