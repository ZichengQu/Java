package com.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bean.User;
import com.dao.UserDao;
@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void add(){
		System.out.println("service......");
		userDao.add();
	}
	public void update(){
		System.out.println("service......");
		userDao.update();
	}
	public void delete(){
		userDao.delete();
	}
	public User findById(){
		return userDao.findById();
	}
	//��ѯȫ��
	public List<User> query(){
		return userDao.query();
	}
	//ģ����ѯ
	public List<User> selUserByName(String name){
		return userDao.selUserByName(name);
	}
	//��ҳ��ѯ
	public List<User> selUserByPage(Integer pageIndex,Integer pageSize){
		return userDao.selUserByPage(pageIndex, pageSize);
	}
	
}
