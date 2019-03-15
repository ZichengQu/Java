package com.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;

@Service(value="userService")
public class UserService {
	//得到Dao的对象
	//1.定义Dao类型的属性，在属性上面使用注解完成对象注入
	/*@Autowired*/
	//name属性值写注解创建dao对象的value值
	@Resource(name="userDao")
	private UserDao userDao;
	//使用注解不需要set方法
	public void add(){
		System.out.println("service......");
		userDao.add();
	}
}
