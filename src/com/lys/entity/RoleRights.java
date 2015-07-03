package com.lys.entity;

/**
 * RoleRights entity. @author MyEclipse Persistence Tools
 */

public class RoleRights implements java.io.Serializable {

	// Fields

	private Integer roleRightsId;
	private Rights rights;
	private Role role;
	private Integer type;

	// Constructors

	/** default constructor */
	public RoleRights() {
	}

	/** full constructor */
	public RoleRights(Rights rights, Role role, Integer type) {
		this.rights = rights;
		this.role = role;
		this.type = type;
	}

	// Property accessors

	public Integer getRoleRightsId() {
		return this.roleRightsId;
	}

	public void setRoleRightsId(Integer roleRightsId) {
		this.roleRightsId = roleRightsId;
	}

	public Rights getRights() {
		return this.rights;
	}

	public void setRights(Rights rights) {
		this.rights = rights;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}