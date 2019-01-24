package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Users;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(urlPatterns= "*.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String servletPath = request.getServletPath();
		if("/selUserByName.do".equals(servletPath)) {
			selUserByName(request,response);
		}
	}

	private void selUserByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();//ajax的success必须通过流返回参数，流的参数不会打印在页面上，只会当作参数返回;
		String username = request.getParameter("username");
		Users user = userService.selUserByName(username);
		if(user!=null) {
			writer.print("true");
		}else{
			writer.print("false");
		}
		System.out.println(user);
	}

}
