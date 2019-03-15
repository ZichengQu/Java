package com.service;

import com.dao.UserDao;

public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void add(){
		userDao.add();
		System.out.println("service......");
	}
}
