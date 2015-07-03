package com.lys.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Groups entity. @author MyEclipse Persistence Tools
 */

public class Groups implements java.io.Serializable {

	// Fields

	private Integer groupsId;
	private Integer parentId;
	private String name;
	private String description;
	private Timestamp createTime;
	private Set groupsRoles = new HashSet(0);
	private Set groupsRightses = new HashSet(0);
	private Set userGroupses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Groups() {
	}

	/** full constructor */
	public Groups(Integer parentId, String name, String description,
			Timestamp createTime, Set groupsRoles, Set groupsRightses,
			Set userGroupses) {
		this.parentId = parentId;
		this.name = name;
		this.description = description;
		this.createTime = createTime;
		this.groupsRoles = groupsRoles;
		this.groupsRightses = groupsRightses;
		this.userGroupses = userGroupses;
	}

	// Property accessors

	public Integer getGroupsId() {
		return this.groupsId;
	}

	public void setGroupsId(Integer groupsId) {
		this.groupsId = groupsId;
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

	public Set getGroupsRoles() {
		return this.groupsRoles;
	}

	public void setGroupsRoles(Set groupsRoles) {
		this.groupsRoles = groupsRoles;
	}

	public Set getGroupsRightses() {
		return this.groupsRightses;
	}

	public void setGroupsRightses(Set groupsRightses) {
		this.groupsRightses = groupsRightses;
	}

	public Set getUserGroupses() {
		return this.userGroupses;
	}

	public void setUserGroupses(Set userGroupses) {
		this.userGroupses = userGroupses;
	}

}