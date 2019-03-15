package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.Book;
import com.bean.User;
import com.service.BookService;
import com.service.UserService;

public class SpringTest {
	@Test
	public void test(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Book book=(Book)context.getBean("book");
		book.add();
	}
}
