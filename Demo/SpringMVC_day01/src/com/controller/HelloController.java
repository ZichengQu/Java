package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/helloController")
public class HelloController {
	
	@RequestMapping(path = "/hello")
	public String sayHello() {
		System.out.println("HelloController 的 sayHello 方法执行了...");
		//在SpringMVC中，return的字符串可以作为要响应的页面,/WebContent/WEB-INF/pages/success.jsp,没有写前后路径是因为在SpringMVC.xml里配置了前缀和后缀。
		return "success";//返回普通的字符串，默认为响应页面的名字
	}
	
	//@RequestMapping(path = "/testRequestMapping")
	//@RequestMapping(path = "/testRequestMapping", method = {RequestMethod.POST})
	//@RequestMapping(path = "/testRequestMapping", method = {RequestMethod.POST},params = {"username"})
	//@RequestMapping(path = "/testRequestMapping", method = {RequestMethod.POST},params = {"username=heihei"})//只有当参数也是heihei的时候才会执行，否则报错。
	@RequestMapping(path = "/testRequestMapping", method = {RequestMethod.GET},params = {"username=heihei"},headers = {"Accept"})
	public String testRequestMapping() {
		System.out.println("testRequestMapping 注解测试");
		return "success";
	}
}
