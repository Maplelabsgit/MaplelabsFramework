package com.maplelabs.framework.guestbook.rest.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maplelabs.framework.guestbook.service.UserCommentService;

//Component annotation must be defined for creation of Autowired fields in Rest Controllers
@Component("userCommentFindByIdProcessor")
public class UserCommentFindByIdProcessor extends RestProcessor<com.maplelabs.framework.guestbook.response.UserComment>{

	@Autowired
	private UserCommentService userCommentService;
	
	private int id;

	private com.maplelabs.framework.guestbook.domain.UserComment domain;
	private com.maplelabs.framework.guestbook.response.UserComment model;
	
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
	protected void doProcess() {
		
		id = (int) request.data;
		
        try {
        	domain = this.userCommentService.findUserCommentById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void postProcess() {
		model = new com.maplelabs.framework.guestbook.response.UserComment();
		
		model.setId(domain.getId());
		model.setComment(domain.getComment());
		model.setUserId(domain.getTblUser().getId());
		
    	result = model;
	}

}
