/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cisco.acisizing.acisizing.rest.controller;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dhavalnagar
 */
@XmlRootElement
public class Result {
    private boolean status;
    private String message;
    private Object data;
    private String token;
    private String userId;

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
