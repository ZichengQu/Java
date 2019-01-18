package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		//��ȡ���������Ӧ��valueֵ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"\n"+password);
		//��������Ĳ��������֣��������������Ӧ���ַ������顣
		String[] hobby = request.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobby));
		//��ȡ�����URI
		String uri = request.getRequestURI();
		System.out.println(uri);//Servlet_day01/login
		StringBuffer url = request.getRequestURL();
		System.out.println(url);//http://localhost:8080/Servlet_day01/login
		//��ȡ����ʽ
		String method = request.getMethod();
		System.out.println(method);//���ݾ����method��GET��POST��
		//����һ��GET�����ȡ���������Ӧ���Ǹ��ַ�������?����ĸ��ַ���
		String queryString = request.getQueryString();
		System.out.println(queryString);
		//��ȡ�����Servlet��ӳ��·��
		String servletPath = request.getServletPath();
		System.out.println(servletPath);//	/login
		
		//������Ӧ���������͡�
		//response.setContentType("application/msword");
		PrintWriter writer = response.getWriter();
		writer.print("<h1>welcome</h1>");
		
	}

}
