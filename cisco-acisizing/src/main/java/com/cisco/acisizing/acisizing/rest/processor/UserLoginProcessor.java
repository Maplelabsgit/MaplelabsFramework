package com.cisco.acisizing.acisizing.rest.processor;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.acisizing.acisizing.authenticator.AbstractAuthenticator;
import com.cisco.acisizing.acisizing.authenticator.AuthenticatorFactory;
import com.cisco.acisizing.acisizing.domain.User;
import com.cisco.acisizing.acisizing.service.UserService;

// Component annotation must be defined for creation of Autowired fields in Rest Controllers
@Component("userLoginProcessor")
public class UserLoginProcessor
		extends
		RestProcessor<com.cisco.acisizing.acisizing.response.User> {
	
	@Autowired
	UserService userService;
	
	private com.cisco.acisizing.acisizing.domain.User domain;
	private com.cisco.acisizing.acisizing.response.User model;
	private String authType;
	
	public com.cisco.acisizing.acisizing.domain.User getDomain() {
		return domain;
	}

	public void setDomain(com.cisco.acisizing.acisizing.domain.User domain) {
		this.domain = domain;
	}

	public com.cisco.acisizing.acisizing.response.User getModel() {
		return model;
	}

	public void setModel(com.cisco.acisizing.acisizing.response.User model) {
		this.model = model;
	}


	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}
	
	@Override
	protected void preProcess() {
		model = new com.cisco.acisizing.acisizing.response.User();
		
		model.setUsername((String) ((List) request.data).get(0));
		model.setPassword((String) ((List) request.data).get(1));
		authType = (String) ((List) request.data).get(2);
	}

	@Override
	public void doProcess() {

		AbstractAuthenticator authenticator;
		try {
			authenticator = AuthenticatorFactory.getAuthenticator(authType);
			domain = (User) authenticator.authenticate(model.getUsername(), model.getPassword());
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void postProcess() {
		model = new com.cisco.acisizing.acisizing.response.User();
		
		model.setId(domain.getId());
		model.setUsername(domain.getUsername());
		model.setPassword(domain.getPassword());
		model.setEmailAddress(domain.getEmailAddress());
		model.setAddress(domain.getAddress());
		model.setCreationTime(domain.getCreationTime());
		
		result = model;
	}

}
