package com.bean;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	//�ͻ�id
	private Integer cid;
	//�ͻ�����
	private String custName;
	//�ͻ�����
	private String custLevel;
	//�ͻ���Դ
	private String custSource;
	//��ϵ�绰
	private String custPhone;
	//�ֻ�
	private String custMobile;
	//�ڿͻ�ʵ���������ʾ�����ϵ��
	//hibernateҪ��ʹ��set���ϱ�ʾ�������,��Ϊһ�Զ�(���һ�������ظ�)
	private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();
	
	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}
	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	
}
