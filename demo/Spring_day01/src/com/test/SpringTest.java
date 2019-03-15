package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Book;
import com.bean.Person;
import com.bean.Proterty;
import com.bean.User;
import com.service.UserService;

public class SpringTest {
	@Test
	public void testUser(){
		//1.����spring�����ļ����������ô�������
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.�õ����ô�������
		Person person = (Person) context.getBean("person");
		System.out.println("person="+person);
		person.test();
		
	}
}
