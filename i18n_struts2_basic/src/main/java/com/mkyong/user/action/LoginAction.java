package com.mkyong.user.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.mkyong.user.model.Bean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private List<Bean> beans;

	public List<Bean> getBeans() {
		return beans;
	}

	public void setBeans(List<Bean> beans) {
		this.beans = beans;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// business logic
	public String execute() {
		String actionName = ActionContext.getContext().getName();
		String namespace = ServletActionContext.getActionMapping().getNamespace();
		if (!namespace.equals("/")){
			System.out.println(namespace+"/"+actionName);
		}else{
			System.out.println(namespace+actionName);
		}

		return "SUCCESS";
	}

}
