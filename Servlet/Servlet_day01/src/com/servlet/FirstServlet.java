package com.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {

	public FirstServlet() {
		System.out.println("FirstServlet无参构造...");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy...");
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
		System.out.println("MyFirstInit...");
		//获取初始化参数
		String username = config.getInitParameter("username");
		System.out.println(username);//admin
		//获得Servlet的名字(Servlet注册的名字)
		String servletName = config.getServletName();
		System.out.println(servletName);//FirstServlet
		//获得ServletContext对象
		ServletContext servletContext = config.getServletContext();
		System.out.println(servletContext);//org.apache.catalina.core.ApplicationContextFacade@458756de
		//获得当前web应用的初始化参数
		String driver = servletContext.getInitParameter("driver");//oracle.jdbc.driver.OracleDriver
		System.out.println(driver);
		//获得web应用中任何资源的绝对路径
		String realPath_A = servletContext.getRealPath("a.txt");//a在WebContent目录里。
		String realPath_B = servletContext.getRealPath("/WEB-INF/b.txt");//b在WebContent/WEB-INF目录里。
		String realPath_C = servletContext.getRealPath("/WEB-INF/classes/c.txt");//c在WebContent/WEB-INF/classes目录里。
		String realPath_D = servletContext.getRealPath("path");//找不到，因为d不算是web项目里的文件，d是eclipse的workkplace里的文件。
		System.out.printf("realPath_A: "+realPath_A+"\nrealPath_B: "+realPath_B+"\nrealPath_C: "+realPath_C+"\nrealPath_D: "+realPath_D);
		//向域对象中存数据
		servletContext.setAttribute("name", "name_value");
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Service...");
	}

}
