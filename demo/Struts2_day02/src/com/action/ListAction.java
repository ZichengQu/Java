package com.action;

import java.util.List;

import com.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport {
	//5.1��װ���ݵ�List����
	//5.1.1��action������List����
	private List<User> list;
	//5.1.2����List���ϵ�get��set����
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
