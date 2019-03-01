package com.action;

public class HelloAction {
	/*
	 * 每次访问servlet的时候，都会执行service方法,写类继承HttpServlet，重写类里面的方法,在web.xml中配置Servlet的访问路径;
	 * 每次访问Action的时候，默认执行名称为execute的方法;
	 */
	public String execute() {
		System.out.println("execute...");
		return "ok";
	}
	public String update() {
		System.out.println("update...");
		return "ok";
	}
}
