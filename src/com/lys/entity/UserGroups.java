package com.lys.entity;

/**
 * UserGroups entity. @author MyEclipse Persistence Tools
 */

public class UserGroups implements java.io.Serializable {

	// Fields

	private Integer userGroupsId;
	private User user;
	private Groups groups;

	// Constructors

	/** default constructor */
	public UserGroups() {
	}

	/** full constructor */
	public UserGroups(User user, Groups groups) {
		this.user = user;
		this.groups = groups;
	}

	// Property accessors

	public Integer getUserGroupsId() {
		return this.userGroupsId;
	}

	public void setUserGroupsId(Integer userGroupsId) {
		this.userGroupsId = userGroupsId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Groups getGroups() {
		return this.groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

}