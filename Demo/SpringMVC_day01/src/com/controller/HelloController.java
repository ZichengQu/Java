package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/helloController")
public class HelloController {
	
	@RequestMapping(path = "/hello")
	public String sayHello() {
		System.out.println("HelloController �� sayHello ����ִ����...");
		//��SpringMVC�У�return���ַ���������ΪҪ��Ӧ��ҳ��,/WebContent/WEB-INF/pages/success.jsp,û��дǰ��·������Ϊ��SpringMVC.xml��������ǰ׺�ͺ�׺��
		return "success";//������ͨ���ַ�����Ĭ��Ϊ��Ӧҳ�������
	}
	
	//@RequestMapping(path = "/testRequestMapping")
	//@RequestMapping(path = "/testRequestMapping", method = {RequestMethod.POST})
	//@RequestMapping(path = "/testRequestMapping", method = {RequestMethod.POST},params = {"username"})
	//@RequestMapping(path = "/testRequestMapping", method = {RequestMethod.POST},params = {"username=heihei"})//ֻ�е�����Ҳ��heihei��ʱ��Ż�ִ�У����򱨴�
	@RequestMapping(path = "/testRequestMapping", method = {RequestMethod.GET},params = {"username=heihei"},headers = {"Accept"})
	public String testRequestMapping() {
		System.out.println("testRequestMapping ע�����");
		return "success";
	}
}
