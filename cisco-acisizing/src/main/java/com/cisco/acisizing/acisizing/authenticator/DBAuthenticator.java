package com.cisco.acisizing.acisizing.authenticator;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.acisizing.acisizing.domain.User;
import com.cisco.acisizing.acisizing.service.UserService;

//Component must be specified for bean creation 
@Component("dbAuthenticator")
public class DBAuthenticator extends AbstractAuthenticator {

	@Autowired
	UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User authenticate(String username, String password) {
		
		User domain = null;
		
		try {
			domain = userService.findUserByName(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (domain == null) {
			throw new WebApplicationException("user not exist",
					Response.Status.UNAUTHORIZED);

		} else if (!domain.getPassword().equals(password)) {
			throw new WebApplicationException("password not correct",
					Response.Status.UNAUTHORIZED);
		}
		
		return domain;
	}

}
