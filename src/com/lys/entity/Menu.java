package com.lys.entity;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer pid;
	private String text;
	private String state;
	private Boolean checked;
	private String url;
	private String iconCls;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** full constructor */
	public Menu(Integer pid, String text, String state, Boolean checked,
			String url, String iconCls) {
		this.pid = pid;
		this.text = text;
		this.state = state;
		this.checked = checked;
		this.url = url;
		this.iconCls = iconCls;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getChecked() {
		return this.checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIconCls() {
		return this.iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

}