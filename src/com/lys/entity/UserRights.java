package com.lys.entity;

/**
 * UserRights entity. @author MyEclipse Persistence Tools
 */

public class UserRights implements java.io.Serializable {

	// Fields

	private Integer userRightsId;
	private Rights rights;
	private User user;
	private Integer type;

	// Constructors

	/** default constructor */
	public UserRights() {
	}

	/** full constructor */
	public UserRights(Rights rights, User user, Integer type) {
		this.rights = rights;
		this.user = user;
		this.type = type;
	}

	// Property accessors

	public Integer getUserRightsId() {
		return this.userRightsId;
	}

	public void setUserRightsId(Integer userRightsId) {
		this.userRightsId = userRightsId;
	}

	public Rights getRights() {
		return this.rights;
	}

	public void setRights(Rights rights) {
		this.rights = rights;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}