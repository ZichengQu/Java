package com.bean;

import java.util.HashSet;
import java.util.Set;

public class Role {
	//��ɫid
	private Integer rid;
	//��ɫ����
	private String rname;
	//��ɫ����
	private String rdesc;
	//��ɫ�����ʾ�û�
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
