package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class ActionSupportDemo extends ActionSupport {
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String add() throws Exception {
		System.out.println("add...");
		return NONE;
	}
	public String update() throws Exception {
		System.out.println("update...");
		return NONE;
	}
}
