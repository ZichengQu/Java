package com.action;

import com.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class ObjectAction extends ActionSupport {
	//1.����������
	User user = new User();
	//2.����get����
	public User getUser() {
		return user;
	}
	@Override
	public String execute() throws Exception {
		//3.��User���������
		user.setUsername("admin");
		user.setPassword("123456");
		return SUCCESS;
	}
}
