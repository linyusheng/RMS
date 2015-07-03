package com.lys.entity;

/**
 * GroupsRole entity. @author MyEclipse Persistence Tools
 */

public class GroupsRole implements java.io.Serializable {

	// Fields

	private Integer groupsRoleId;
	private Role role;
	private Groups groups;

	// Constructors

	/** default constructor */
	public GroupsRole() {
	}

	/** full constructor */
	public GroupsRole(Role role, Groups groups) {
		this.role = role;
		this.groups = groups;
	}

	// Property accessors

	public Integer getGroupsRoleId() {
		return this.groupsRoleId;
	}

	public void setGroupsRoleId(Integer groupsRoleId) {
		this.groupsRoleId = groupsRoleId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Groups getGroups() {
		return this.groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

}