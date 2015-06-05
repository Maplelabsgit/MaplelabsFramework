package com.maplelabs.framework.guestbook.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserComment {

	private int id;
	private String comment;
	private int userId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
