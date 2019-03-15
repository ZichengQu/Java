package com.service;

import java.util.List;

import com.bean.User;
import com.dao.UserDao;

public class UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public List<User> select(){
		return userDao.select();
	}
}
