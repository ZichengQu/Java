package com.service;

import com.dao.UserDao;

public class UserService {
	//1.����dao���͵�����
	private UserDao uDao;
	//2.����set����
	public void setUDao(UserDao uDao){
		this.uDao=uDao;
	}
	public void add(){
		System.out.println("service......");
		//��service����õ�dao�Ķ��󣬲��ܵ���dao����ķ���
		//UserDao uDao=new UserDao();
		uDao.add();	
	}
}


