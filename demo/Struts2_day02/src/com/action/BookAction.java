package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		System.out.println("BookAction...");
		return SUCCESS;
	}
}
