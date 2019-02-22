package com.bean;

import java.util.HashSet;
import java.util.Set;

public class Role {
	//角色id
	private Integer rid;
	//角色名称
	private String rname;
	//角色描述
	private String rdesc;
	//角色类里表示用户
	private Set<User> userSet = new HashSet<User>();

	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRdesc() {
		return rdesc;
	}
	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}
	
}
