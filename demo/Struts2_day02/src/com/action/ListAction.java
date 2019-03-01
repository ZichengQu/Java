package com.action;

import java.util.List;

import com.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport {
	//5.1封装数据到List集合
	//5.1.1在action中声明List集合
	private List<User> list;
	//5.1.2生成List集合的get和set方法
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(list);
		return NONE;
	}
	
}
