package com.service;

import com.dao.UserDao;

public class UserService {
	//1.定义dao类型的属性
	private UserDao uDao;
	//2.生成set方法
	public void setUDao(UserDao uDao){
		this.uDao=uDao;
	}
	public void add(){
		System.out.println("service......");
		//在service里面得到dao的对象，才能调用dao里面的方法
		//UserDao uDao=new UserDao();
		uDao.add();	
	}
}


