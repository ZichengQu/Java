package com.action;

public class HelloAction {
	/*
	 * ÿ�η���servlet��ʱ�򣬶���ִ��service����,д��̳�HttpServlet����д������ķ���,��web.xml������Servlet�ķ���·��;
	 * ÿ�η���Action��ʱ��Ĭ��ִ������Ϊexecute�ķ���;
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
