package com.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Account;
import com.bean.User;

/*
 * 请求参数的绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

	//4.1	封装零散属性
	@RequestMapping("/testParam")
	public String testParam(String username, String password) {
		System.out.println("testParam执行了, username: "+username+", password: "+password);//testParam执行了, username: hehe, password: 123
		return "success";
	}
	
	/*
	 * 4.2	把请求参数封装到实体类中
	 * 4.4	把请求参数封装到List和Map中
	 * 请求参数绑定把数据封装到JavaBean的类中;
	 * 实体类中一定要有相应的get和set方法；
	 * 表单中的name属性一定要和实体类的属性名称一样；
	 * 若是需要在Account对象中封装其它对象User，则需要在Account里添加属性User，并写get和set方法；同时在form表单的name中需要写"user.***"
	 */
	@RequestMapping("/saveAccount")
	public String saveAccount(Account account) {
		System.out.println("saveAccount执行了");
		System.out.println(account);
		return "success";
	}
	
	//4.5	自定义类型转换器
	@RequestMapping("/saveUser")
	public String saveUser(User user) {
		System.out.println("saveUser执行了");
		System.out.println(user);
		return "success";
	}
	
	//4.6	获取Servlet原生API
	@RequestMapping("/testServlet")
	public String testServlet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("testServlet执行了");
		HttpSession session = request.getSession();
		ServletContext servletContext = session.getServletContext();
		System.out.println("request: "+request+"\nresponse: "+response+"\nsession: "+session+"\nservletContext: "+servletContext+"\nresponse: "+response);
		return "success";
	}
}
