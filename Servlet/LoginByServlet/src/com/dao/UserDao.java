package com.dao;

import java.util.List;

import com.bean.User;

public interface UserDao {
	public User login(String username, String password) throws Exception;
	public List<User> queryAll() throws Exception;
}
