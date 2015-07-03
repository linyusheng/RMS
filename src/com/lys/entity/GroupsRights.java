package com.lys.entity;

/**
 * GroupsRights entity. @author MyEclipse Persistence Tools
 */

public class GroupsRights implements java.io.Serializable {

	// Fields

	private Integer groupsRightId;
	private Rights rights;
	private Groups groups;
	private Integer type;

	// Constructors

	/** default constructor */
	public GroupsRights() {
	}

	/** full constructor */
	public GroupsRights(Rights rights, Groups groups, Integer type) {
		this.rights = rights;
		this.groups = groups;
		this.type = type;
	}

	// Property accessors

	public Integer getGroupsRightId() {
		return this.groupsRightId;
	}

	public void setGroupsRightId(Integer groupsRightId) {
		this.groupsRightId = groupsRightId;
	}

	public Rights getRights() {
		return this.rights;
	}

	public void setRights(Rights rights) {
		this.rights = rights;
	}

	public Groups getGroups() {
		return this.groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}