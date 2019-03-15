package com.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bean.User;
import com.service.OrderService;
import com.service.UserService;

public class SpringTest {
	@Test
	public void testAdd(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService=(UserService)context.getBean("userService");
		List<User> users = userService.select();
		System.out.println(users);
		
		OrderService orderService=(OrderService)context.getBean("orderService");
		orderService.account();
	}
}
