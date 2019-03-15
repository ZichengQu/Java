package com.dao;

import org.springframework.stereotype.Repository;

@Repository(value="userDao")
public class UserDao {
	public void add(){
		System.out.println("dao......");
	}
}
