package com.service.impl;

import com.bean.User;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;
import java.util.*;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public boolean login(String username, String password) {
		try {
			User user = userDao.login(username,password);
			if(user==null) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public List<User> queryAll() {
		List<User> list = null;
		try {
			list = userDao.queryAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
