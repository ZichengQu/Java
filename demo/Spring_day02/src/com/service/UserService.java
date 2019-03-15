package com.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;

@Service(value="userService")
public class UserService {
	//�õ�Dao�Ķ���
	//1.����Dao���͵����ԣ�����������ʹ��ע����ɶ���ע��
	/*@Autowired*/
	//name����ֵдע�ⴴ��dao�����valueֵ
	@Resource(name="userDao")
	private UserDao userDao;
	//ʹ��ע�ⲻ��Ҫset����
	public void add(){
		System.out.println("service......");
		userDao.add();
	}
}
