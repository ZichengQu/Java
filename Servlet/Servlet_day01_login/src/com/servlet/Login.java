package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig servletConfig = this.getServletConfig();
		ServletContext servletContext = servletConfig.getServletContext();
		String username = servletContext.getInitParameter("username");
		String password = servletContext.getInitParameter("password");
		
		request.setCharacterEncoding("UTF-8");
		String username_u = request.getParameter("username");
		//username_u = new String(username_u.getBytes("iso-8859-1"),"UTF-8");//��post�ύ����ʱ�������룬�����ַ�ʽת�롣
		String password_u = request.getParameter("password");
		System.out.println(username+"\n"+username_u+"\n"+password+"\n"+password_u);
		
		//������Ӧ���������Լ������ʽ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		if(username.equals(username_u)&&password.equals(password_u)) {
			writer.print("�ɹ�");
		}else {
			writer.print("ʧ��");
		}
	}

}
