package com.galaxy.bean;

import java.util.Date;

public class Account {

	private int id;
	private String name;
	private String password;

	private Date createTime;
	private Date updateTime;

	private String remark;
	private boolean deleteFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
