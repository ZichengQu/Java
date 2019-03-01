package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		System.out.println("OrderAction...");
		return SUCCESS;
	}

	public OrderAction() {
		System.out.println("无参构造...");
	}
	
}
