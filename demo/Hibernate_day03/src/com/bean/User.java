package com.bean;

import java.util.HashSet;
import java.util.Set;

public class User {
	//用户id
	private Integer uid;
	//用户名称
	private String username;
	//用户密码
	private String password;
	//用户类里表示角色
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
