package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport {
	//1.定义List集合变量
	private List<User> list = new ArrayList<User>();
	//2.生成变量的get方法
	public List<User> getList() {
		return list;
	}
	@Override
	public String execute() throws Exception {
		//3.向list集合中设置值
		list.add(new User("Jack", "123456"));
		list.add(new User("Mary", "654321"));
		return SUCCESS;
	}
}
