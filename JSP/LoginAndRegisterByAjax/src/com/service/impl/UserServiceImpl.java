package com.service.impl;

import com.bean.Users;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public Users selUserByName(String name) {
		Users user = null;
		try {
			user = userDao.selUserByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
