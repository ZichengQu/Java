package com.bean;

import java.util.HashSet;
import java.util.Set;

public class User {
	//�û�id
	private Integer uid;
	//�û�����
	private String username;
	//�û�����
	private String password;
	//�û������ʾ��ɫ
	private Set<Role> roleSet = new HashSet<Role>();
	
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
