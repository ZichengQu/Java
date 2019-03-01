package com.action;

import com.opensymphony.xwork2.Action;

public class UserAction implements Action {

	@Override
	public String execute() throws Exception {
		return NONE;
	}

	public String add() throws Exception {
		return SUCCESS;
	}
}
