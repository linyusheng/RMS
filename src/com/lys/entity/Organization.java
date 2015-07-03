package com.lys.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Organization entity. @author MyEclipse Persistence Tools
 */

public class Organization implements java.io.Serializable {

	// Fields

	private Integer organizationId;
	private Integer parentId;
	private String name;
	private String description;
	private Timestamp createTime;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Organization() {
	}

	/** full constructor */
	public Organization(Integer parentId, String name, String description,
			Timestamp createTime, Set users) {
		this.parentId = parentId;
		this.name = name;
		this.description = description;
		this.createTime = createTime;
		this.users = users;
	}

	// Property accessors

	public Integer getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
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

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}