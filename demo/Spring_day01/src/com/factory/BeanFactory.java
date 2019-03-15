package com.factory;

import com.bean.User;

public class BeanFactory {
	//静态工厂返回User对象
	public static User getUser1(){
		return new User();
	}
	
	//普通方法返回User对象
	public User getUser2(){
		return new User();
	}
}
