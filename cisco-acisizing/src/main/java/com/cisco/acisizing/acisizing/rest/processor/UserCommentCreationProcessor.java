package com.cisco.acisizing.acisizing.rest.processor;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.acisizing.acisizing.response.UserComment;
import com.cisco.acisizing.acisizing.service.UserCommentService;
import com.cisco.acisizing.acisizing.service.UserService;

//Component annotation must be defined for creation of Autowired fields in Rest Controllers
@Component("userCommentCreationProcessor")
public class UserCommentCreationProcessor extends RestProcessor<String> {

	@Autowired
	private UserCommentService userCommentService;
	
	@Autowired
	private UserService userService;
	
	private com.cisco.acisizing.acisizing.domain.UserComment domain;
	private com.cisco.acisizing.acisizing.response.UserComment model;

	public UserCommentService getUserCommentService() {
		return userCommentService;
	}

	public void setUserCommentService(UserCommentService userCommentService) {
		this.userCommentService = userCommentService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public com.cisco.acisizing.acisizing.domain.UserComment getDomain() {
		return domain;
	}

	public void setDomain(
			com.cisco.acisizing.acisizing.domain.UserComment domain) {
		this.domain = domain;
	}

	public com.cisco.acisizing.acisizing.response.UserComment getModel() {
		return model;
	}

	public void setModel(
			com.cisco.acisizing.acisizing.response.UserComment model) {
		this.model = model;
	}

	@Override
	protected void preProcess() {
		model = (UserComment) request.data;
		
		domain = new com.cisco.acisizing.acisizing.domain.UserComment();
		
		domain.setComment(model.getComment());
		try {
			domain.setTblUser(userService.findUserById(model.getUserId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doProcess() {
		JSONObject json = new JSONObject();
    	
        try {
        	userCommentService.createUserComment(domain);
        	json.put("success",  true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("failure", false);
		}
        
        result = json.toString();
	}
}
