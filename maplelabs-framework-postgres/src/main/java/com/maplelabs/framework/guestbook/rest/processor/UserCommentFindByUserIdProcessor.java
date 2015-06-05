package com.maplelabs.framework.guestbook.rest.processor;

import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maplelabs.framework.guestbook.domain.UserComment;
import com.maplelabs.framework.guestbook.service.UserCommentService;

//Component annotation must be defined for creation of Autowired fields in Rest Controllers
@Component("userCommentFindByUserIdProcessor")
public class UserCommentFindByUserIdProcessor extends RestProcessor<String>{

	@Autowired
	private UserCommentService userCommentService;
	
	private int userId;

	private List<UserComment> userCommentList;
	
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

	public List<UserComment> getUserCommentList() {
		return userCommentList;
	}

	public void setUserCommentList(List<UserComment> userCommentList) {
		this.userCommentList = userCommentList;
	}

	@Override
	protected void doProcess() {
		
		userId = (int) request.data;
		
        try {
        	userCommentList = this.userCommentService.findUserCommentsByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void postProcess() {
		JSONArray jsonArray = new JSONArray();
		JSONObject json = null;
    	for(Iterator<UserComment> it = userCommentList.iterator(); it.hasNext();) {
    		UserComment userComment = it.next();
    		json = new JSONObject();
    		json.put("id",userComment.getId());
    		json.put("comment",userComment.getComment());
    		//json.put("creationTime", userComment.getCreationTime().toString());
    		
    		jsonArray.put(json);
    	}
    	
    	result = jsonArray.toString();
	}

}
