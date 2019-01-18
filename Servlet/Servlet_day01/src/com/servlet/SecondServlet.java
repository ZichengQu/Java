package com.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("SecondServlet Init...");
		ServletContext servletContext = config.getServletContext();
		//从域对象中获取数据
		String name = (String) servletContext.getAttribute("name");
		System.out.println(name);//name_value
		//移除数据
		servletContext.removeAttribute("name");
		name = (String) servletContext.getAttribute("name");
		System.out.println(name);//null
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("2.Service...");
	}

}
