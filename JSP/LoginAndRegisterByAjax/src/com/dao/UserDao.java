package com.dao;

import com.bean.Users;

public interface UserDao {
	public Users selUserByName(String name) throws Exception;
}
