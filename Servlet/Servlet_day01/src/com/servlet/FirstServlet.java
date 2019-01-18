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
		System.out.println("FirstServlet�޲ι���...");
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
		//��ȡ��ʼ������
		String username = config.getInitParameter("username");
		System.out.println(username);//admin
		//���Servlet������(Servletע�������)
		String servletName = config.getServletName();
		System.out.println(servletName);//FirstServlet
		//���ServletContext����
		ServletContext servletContext = config.getServletContext();
		System.out.println(servletContext);//org.apache.catalina.core.ApplicationContextFacade@458756de
		//��õ�ǰwebӦ�õĳ�ʼ������
		String driver = servletContext.getInitParameter("driver");//oracle.jdbc.driver.OracleDriver
		System.out.println(driver);
		//���webӦ�����κ���Դ�ľ���·��
		String realPath_A = servletContext.getRealPath("a.txt");//a��WebContentĿ¼�
		String realPath_B = servletContext.getRealPath("/WEB-INF/b.txt");//b��WebContent/WEB-INFĿ¼�
		String realPath_C = servletContext.getRealPath("/WEB-INF/classes/c.txt");//c��WebContent/WEB-INF/classesĿ¼�
		String realPath_D = servletContext.getRealPath("path");//�Ҳ�������Ϊd������web��Ŀ����ļ���d��eclipse��workkplace����ļ���
		System.out.printf("realPath_A: "+realPath_A+"\nrealPath_B: "+realPath_B+"\nrealPath_C: "+realPath_C+"\nrealPath_D: "+realPath_D);
		//��������д�����
		servletContext.setAttribute("name", "name_value");
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Service...");
	}

}
