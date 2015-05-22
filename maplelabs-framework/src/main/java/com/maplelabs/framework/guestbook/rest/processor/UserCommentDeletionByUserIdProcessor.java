package com.maplelabs.framework.guestbook.rest.processor;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maplelabs.framework.guestbook.service.UserCommentService;

//Component annotation must be defined for creation of Autowired fields in Rest Controllers
@Component("userCommentDeletionByUserIdProcessor")
public class UserCommentDeletionByUserIdProcessor extends RestProcessor<String>{

	@Autowired
	private UserCommentService userCommentService;
	
	private int userId;

	public UserCommentService getUserCommentService() {
		return userCommentService;
	}

	public void setUserCommentService(UserCommentService userCommentService) {
		this.userCommentService = userCommentService;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	protected void doProcess() {
		
		userId = (int) request.data;
		
		JSONObject json = new JSONObject();
    	
        try {
        	this.userCommentService.deleteUserCommentByUserId(userId);
        	json.put("success",  true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("failure", false);
		}
        
        result = json.toString();
	}
}
