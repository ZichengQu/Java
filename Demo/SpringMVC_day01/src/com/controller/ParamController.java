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
 * ��������İ�
 */
@Controller
@RequestMapping("/param")
public class ParamController {

	//4.1	��װ��ɢ����
	@RequestMapping("/testParam")
	public String testParam(String username, String password) {
		System.out.println("testParamִ����, username: "+username+", password: "+password);//testParamִ����, username: hehe, password: 123
		return "success";
	}
	
	/*
	 * 4.2	�����������װ��ʵ������
	 * 4.4	�����������װ��List��Map��
	 * ��������󶨰����ݷ�װ��JavaBean������;
	 * ʵ������һ��Ҫ����Ӧ��get��set������
	 * ���е�name����һ��Ҫ��ʵ�������������һ����
	 * ������Ҫ��Account�����з�װ��������User������Ҫ��Account���������User����дget��set������ͬʱ��form����name����Ҫд"user.***"
	 */
	@RequestMapping("/saveAccount")
	public String saveAccount(Account account) {
		System.out.println("saveAccountִ����");
		System.out.println(account);
		return "success";
	}
	
	//4.5	�Զ�������ת����
	@RequestMapping("/saveUser")
	public String saveUser(User user) {
		System.out.println("saveUserִ����");
		System.out.println(user);
		return "success";
	}
	
	//4.6	��ȡServletԭ��API
	@RequestMapping("/testServlet")
	public String testServlet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("testServletִ����");
		HttpSession session = request.getSession();
		ServletContext servletContext = session.getServletContext();
		System.out.println("request: "+request+"\nresponse: "+response+"\nsession: "+session+"\nservletContext: "+servletContext+"\nresponse: "+response);
		return "success";
	}
}
