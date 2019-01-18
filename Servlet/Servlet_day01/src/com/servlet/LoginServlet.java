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
		//获取表单输入项对应的value值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"\n"+password);
		//根据请求的参数的名字，返回请求参数对应的字符串数组。
		String[] hobby = request.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobby));
		//获取请求的URI
		String uri = request.getRequestURI();
		System.out.println(uri);//Servlet_day01/login
		StringBuffer url = request.getRequestURL();
		System.out.println(url);//http://localhost:8080/Servlet_day01/login
		//获取请求方式
		String method = request.getMethod();
		System.out.println(method);//根据具体表单method，GET或POST。
		//若是一个GET请求获取请求参数对应的那个字符串，即?后的哪个字符串
		String queryString = request.getQueryString();
		System.out.println(queryString);
		//获取请求的Servlet的映射路径
		String servletPath = request.getServletPath();
		System.out.println(servletPath);//	/login
		
		//设置响应的内容类型。
		//response.setContentType("application/msword");
		PrintWriter writer = response.getWriter();
		writer.print("<h1>welcome</h1>");
		
	}

}
