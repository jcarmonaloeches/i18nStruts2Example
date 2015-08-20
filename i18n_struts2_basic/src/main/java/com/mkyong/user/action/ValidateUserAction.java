package com.mkyong.user.action;

import java.util.ArrayList;
import java.util.List;

import com.mkyong.user.model.Bean;
import com.opensymphony.xwork2.ActionSupport;

public class ValidateUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private List<Bean> beans;

	// ...getter and setter methods

	// business logic<dependency>

	public String execute() {
		beans = new ArrayList<Bean>();
		for (int i = 0; i < 100; i++) {
			beans.add(new Bean("ID_" + i, "DESC_" + i));
		}
		return "SUCCESS";
	}

	// simple validation
	public void validate() {
		if ("".equals(getUsername())) {
			addFieldError("username", getText("username.required"));
		}
		if ("".equals(getPassword())) {
			addFieldError("password", getText("password.required"));
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Bean> getBeans() {
		return beans;
	}

	public void setBeans(List<Bean> beans) {
		this.beans = beans;
	}

}
