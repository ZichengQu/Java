package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String username;//����ע���ȡ�������ֵ
	private String password;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String query() {
		System.out.println("query...");
		return SUCCESS;
	}
	public String login() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if("admin".equals(username)&&"123456".equals(password)) {
			session.setAttribute("username", username);//Ҳ���԰Ѷ���浽session��
			return query();
		}else {
			return INPUT;
		}	
	}
}
