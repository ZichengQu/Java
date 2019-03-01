package com.action;

import com.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class ObjectAction extends ActionSupport {
	//1.定义对象变量
	User user = new User();
	//2.生成get方法
	public User getUser() {
		return user;
	}
	@Override
	public String execute() throws Exception {
		//3.向User里面放数据
		user.setUsername("admin");
		user.setPassword("123456");
		return SUCCESS;
	}
}
