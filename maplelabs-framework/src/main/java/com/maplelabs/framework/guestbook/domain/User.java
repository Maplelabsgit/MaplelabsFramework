package com.maplelabs.framework.guestbook.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tbl_users database table.
 * 
 */

@Entity
@Table(name="tbl_users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="creation_time")
	private Date creationTime;

	@Column(name="email_address")
	private String emailAddress;

	private String password;

	private String username;

	//bi-directional many-to-one association to UserComment
	@OneToMany(mappedBy="tblUser")
	private List<UserComment> tblUserComments;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserComment> getTblUserComments() {
		return this.tblUserComments;
	}

	public void setTblUserComments(List<UserComment> tblUserComments) {
		this.tblUserComments = tblUserComments;
	}

	public UserComment addTblUserComment(UserComment tblUserComment) {
		getTblUserComments().add(tblUserComment);
		tblUserComment.setTblUser(this);

		return tblUserComment;
	}

	public UserComment removeTblUserComment(UserComment tblUserComment) {
		getTblUserComments().remove(tblUserComment);
		tblUserComment.setTblUser(null);

		return tblUserComment;
	}

}