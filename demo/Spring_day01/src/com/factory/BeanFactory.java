package com.factory;

import com.bean.User;

public class BeanFactory {
	//��̬��������User����
	public static User getUser1(){
		return new User();
	}
	
	//��ͨ��������User����
	public User getUser2(){
		return new User();
	}
}
