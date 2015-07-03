package com.lys.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Rights entity. @author MyEclipse Persistence Tools
 */

public class Rights implements java.io.Serializable {

	// Fields

	private Integer rightsId;
	private Integer parentId;
	private String name;
	private String description;
	private Timestamp createTime;
	private Set roleRightses = new HashSet(0);
	private Set userRightses = new HashSet(0);
	private Set groupsRightses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Rights() {
	}

	/** full constructor */
	public Rights(Integer parentId, String name, String description,
			Timestamp createTime, Set roleRightses, Set userRightses,
			Set groupsRightses) {
		this.parentId = parentId;
		this.name = name;
		this.description = description;
		this.createTime = createTime;
		this.roleRightses = roleRightses;
		this.userRightses = userRightses;
		this.groupsRightses = groupsRightses;
	}

	// Property accessors

	public Integer getRightsId() {
		return this.rightsId;
	}

	public void setRightsId(Integer rightsId) {
		this.rightsId = rightsId;
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

	public Set getRoleRightses() {
		return this.roleRightses;
	}

	public void setRoleRightses(Set roleRightses) {
		this.roleRightses = roleRightses;
	}

	public Set getUserRightses() {
		return this.userRightses;
	}

	public void setUserRightses(Set userRightses) {
		this.userRightses = userRightses;
	}

	public Set getGroupsRightses() {
		return this.groupsRightses;
	}

	public void setGroupsRightses(Set groupsRightses) {
		this.groupsRightses = groupsRightses;
	}

}