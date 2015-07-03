package com.lys.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Organization organization;
	private String userName;
	private String password;
	private String name;
	private String sex;
	private String mobile;
	private String email;
	private Timestamp createTime;
	private Timestamp loginTime;
	private Timestamp lastLoginTime;
	private Integer loginCount;
	private Set userRoles = new HashSet(0);
	private Set userRightses = new HashSet(0);
	private Set userGroupses = new HashSet(0);
	private Set logs = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Organization organization, String userName, String password,
			String name, String sex, String mobile, String email,
			Timestamp createTime, Timestamp loginTime, Timestamp lastLoginTime,
			Integer loginCount, Set userRoles, Set userRightses,
			Set userGroupses, Set logs) {
		this.organization = organization;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.mobile = mobile;
		this.email = email;
		this.createTime = createTime;
		this.loginTime = loginTime;
		this.lastLoginTime = lastLoginTime;
		this.loginCount = loginCount;
		this.userRoles = userRoles;
		this.userRightses = userRightses;
		this.userGroupses = userGroupses;
		this.logs = logs;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

	public Set getUserRightses() {
		return this.userRightses;
	}

	public void setUserRightses(Set userRightses) {
		this.userRightses = userRightses;
	}

	public Set getUserGroupses() {
		return this.userGroupses;
	}

	public void setUserGroupses(Set userGroupses) {
		this.userGroupses = userGroupses;
	}

	public Set getLogs() {
		return this.logs;
	}

	public void setLogs(Set logs) {
		this.logs = logs;
	}

}