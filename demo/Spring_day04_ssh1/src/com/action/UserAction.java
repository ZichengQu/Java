package com.action;

import com.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class UserAction extends ActionSupport{
	private UserService  userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("action...");
		User user = userService.findById();
		System.out.println(user.getName());
		return NONE;
	}
}
