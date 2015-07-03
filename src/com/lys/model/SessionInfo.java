package com.lys.model;

import java.io.Serializable;
import java.util.List;
/**
 * session信息模型
 * 
 * @author 林玉生
 * 
 */
public class SessionInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer userId;				// 用户ID
	private String userName;			// 用户登录名
	private String ip;					// 用户IP
	private List<String> resourceList;	// 用户可以访问的资源地址列表

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return this.userName;
	}

	public List<String> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<String> resourceList) {
		this.resourceList = resourceList;
	}

}
