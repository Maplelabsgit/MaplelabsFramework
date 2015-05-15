package com.maplelabs.framework.guestbook.rest.processor;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maplelabs.framework.guestbook.service.UserService;

// Component annotation must be defined for creation of Autowired fields in Rest Controllers
@Component
public class UserLoginProcess
		extends
		RestProcessor<com.maplelabs.framework.guestbook.response.User> {
	
	@Autowired
	private UserService userService;
	
	private com.maplelabs.framework.guestbook.domain.User domain;
	private com.maplelabs.framework.guestbook.response.User model;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public com.maplelabs.framework.guestbook.domain.User getDomain() {
		return domain;
	}

	public void setDomain(com.maplelabs.framework.guestbook.domain.User domain) {
		this.domain = domain;
	}

	public com.maplelabs.framework.guestbook.response.User getModel() {
		return model;
	}

	public void setModel(com.maplelabs.framework.guestbook.response.User model) {
		this.model = model;
	}


	@Override
	public void doProcess() {
		
			//userService.createUser(domain);
			
			try {
				domain = userService.findUserByName(model.getUsername());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(domain==null){
				throw new WebApplicationException("user not exist",Response.Status.UNAUTHORIZED);
				
			}else if(!domain.getPassword().equals(model.getPassword())){
				throw new WebApplicationException("password not correct", Response.Status.UNAUTHORIZED);
			}
			
		
	}

	@Override
	public void postProcess() {
		model = new com.maplelabs.framework.guestbook.response.User();
		
		model.setId(domain.getId());
		model.setUsername(domain.getUsername());
		model.setPassword(domain.getPassword());
		model.setEmailAddress(domain.getEmailAddress());
		model.setAddress(domain.getAddress());
		model.setCreationTime(domain.getCreationTime());
		
		result = model;
	}

}
