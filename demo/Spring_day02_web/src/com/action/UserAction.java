package com.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class UserAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		System.out.println("action......");
		//ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");//每次访问action的时候，都会加载Spring配置文件
		//从ServletContext域中获得配置对象
		ServletContext sc = ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
		UserService userService=(UserService)context.getBean("userService");
		userService.add();
		return NONE;
	}
}
