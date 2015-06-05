package com.cisco.acisizing.acisizing.rest.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.acisizing.acisizing.response.User;
import com.cisco.acisizing.acisizing.service.UserService;

// Component annotation must be defined for creation of Autowired fields in Rest Controllers
@Component("userCreationProcessor")
public class UserCreationProcessor
		extends
		RestProcessor<com.cisco.acisizing.acisizing.response.User> {
	
	@Autowired
	private UserService userService;
	
	private com.cisco.acisizing.acisizing.domain.User domain;
	private com.cisco.acisizing.acisizing.response.User model;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

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

	@Override
	public void preProcess() {
		model = (User) request.data;
		
		domain = new com.cisco.acisizing.acisizing.domain.User();
		
		domain.setId(model.getId());
		domain.setUsername(model.getUsername());
		domain.setPassword(model.getPassword());
		domain.setEmailAddress(model.getEmailAddress());
		domain.setAddress(model.getAddress());
		domain.setCreationTime(model.getCreationTime());
		
	}

	@Override
	public void doProcess() {
		try {
			com.cisco.acisizing.acisizing.domain.User user = userService.findUserByName(domain.getUsername());
			
			if(user == null) { 
				userService.createUser(domain);
			
				domain = userService.findUserByName(domain.getUsername());
			} else {
				domain = user;
			}
			
		} catch (Exception e) {
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
