package com.example.demo.exceptionClasses;

import com.example.demo.model.Description;

public class DescriptionExists extends Exception {

	private Description description;
	private String msg;
	public DescriptionExists(Description description, String msg) {
		
		this.setDescription(description);
		this.setMsg(msg);
		
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}

}
