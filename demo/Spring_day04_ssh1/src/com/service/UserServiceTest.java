package com.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.User;

public class UserServiceTest {
	private UserService userService;
	@Before
	public void setUp() throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		userService=(UserService)context.getBean("userService");
	}

	@Test
	public void test() {
		List<User> list = userService.selUserByPage(1, 3);
		System.out.println(list);
		
	}

}
