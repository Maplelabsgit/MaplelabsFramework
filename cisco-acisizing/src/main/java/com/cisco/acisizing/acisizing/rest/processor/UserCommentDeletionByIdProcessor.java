package com.cisco.acisizing.acisizing.rest.processor;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.acisizing.acisizing.service.UserCommentService;

//Component annotation must be defined for creation of Autowired fields in Rest Controllers
@Component("userCommentDeletionByIdProcessor")
public class UserCommentDeletionByIdProcessor extends RestProcessor<String>{

	@Autowired
	private UserCommentService userCommentService;
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public UserCommentService getUserCommentService() {
		return userCommentService;
	}

	public void setUserCommentService(UserCommentService userCommentService) {
		this.userCommentService = userCommentService;
	}

	@Override
	protected void doProcess() {
		
		id = (int) request.data;
		
		JSONObject json = new JSONObject();
    	
        try {
        	this.userCommentService.deleteUserCommentById(id);
        	json.put("success",  true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("failure", false);
		}
        
        result = json.toString();
	}
	
}
