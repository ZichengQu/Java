package com.service;

import java.util.List;

import com.bean.User;

public interface UserService {
	public boolean login(String username, String password);
	public List<User> queryAll();
}
