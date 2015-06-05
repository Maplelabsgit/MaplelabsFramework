package com.maplelabs.framework.guestbook.rest.processor;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maplelabs.framework.guestbook.response.UserComment;
import com.maplelabs.framework.guestbook.service.UserCommentService;
import com.maplelabs.framework.guestbook.service.UserService;

//Component annotation must be defined for creation of Autowired fields in Rest Controllers
@Component("userCommentCreationProcessor")
public class UserCommentCreationProcessor extends RestProcessor<String> {

	@Autowired
	private UserCommentService userCommentService;
	
	@Autowired
	private UserService userService;
	
	private com.maplelabs.framework.guestbook.domain.UserComment domain;
	private com.maplelabs.framework.guestbook.response.UserComment model;

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

	public com.maplelabs.framework.guestbook.domain.UserComment getDomain() {
		return domain;
	}

	public void setDomain(
			com.maplelabs.framework.guestbook.domain.UserComment domain) {
		this.domain = domain;
	}

	public com.maplelabs.framework.guestbook.response.UserComment getModel() {
		return model;
	}

	public void setModel(
			com.maplelabs.framework.guestbook.response.UserComment model) {
		this.model = model;
	}

	@Override
	protected void preProcess() {
		model = (UserComment) request.data;
		
		domain = new com.maplelabs.framework.guestbook.domain.UserComment();
		
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
