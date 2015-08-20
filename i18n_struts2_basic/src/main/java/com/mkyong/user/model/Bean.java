package com.mkyong.user.model;


public class Bean {

	private String id;
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Bean(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Bean() {
		super();
	}

	

}
