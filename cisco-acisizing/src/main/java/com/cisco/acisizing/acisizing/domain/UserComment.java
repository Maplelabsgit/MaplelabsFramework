package com.cisco.acisizing.acisizing.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the tbl_user_comments database table.
 * 
 */
@Entity
@Table(name="tbl_user_comments")
@NamedQuery(name="UserComment.findAll", query="SELECT u FROM UserComment u")
public class UserComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private String comment;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User tblUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_time")
	private Date creationTime;

	public UserComment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getTblUser() {
		return this.tblUser;
	}

	public void setTblUser(User tblUser) {
		this.tblUser = tblUser;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

}