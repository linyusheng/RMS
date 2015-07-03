package com.lys.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private Integer parentId;
	private String name;
	private String description;
	private Timestamp createTime;
	private Set userRoles = new HashSet(0);
	private Set groupsRoles = new HashSet(0);
	private Set roleRightses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(Integer parentId, String name, String description,
			Timestamp createTime, Set userRoles, Set groupsRoles,
			Set roleRightses) {
		this.parentId = parentId;
		this.name = name;
		this.description = description;
		this.createTime = createTime;
		this.userRoles = userRoles;
		this.groupsRoles = groupsRoles;
		this.roleRightses = roleRightses;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

	public Set getGroupsRoles() {
		return this.groupsRoles;
	}

	public void setGroupsRoles(Set groupsRoles) {
		this.groupsRoles = groupsRoles;
	}

	public Set getRoleRightses() {
		return this.roleRightses;
	}

	public void setRoleRightses(Set roleRightses) {
		this.roleRightses = roleRightses;
	}

}