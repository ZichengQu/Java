package com.bean;

public class LinkMan {
	//��ϵ�˱�ţ�������
	private Integer lkm_id;
	//��ϵ������
	private String lkm_name;
	//��ϵ���Ա�
	private String lkm_gender;
	//��ϵ�˰칫�绰
	private String lkm_phone;
	//����ϵ��ʵ���������ʾ�����ͻ�
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(Integer lkm_id) {
		this.lkm_id = lkm_id;
	}
	public String getLkm_name() {
		return lkm_name;
	}
	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}
	public String getLkm_gender() {
		return lkm_gender;
	}
	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}
	public String getLkm_phone() {
		return lkm_phone;
	}
	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}
	
	
}
