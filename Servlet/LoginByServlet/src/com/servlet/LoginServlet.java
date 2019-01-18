package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//解决响应时中文乱码的问题。
		request.setCharacterEncoding("UTF-8");//解决表单post提交中文时的乱码问题。
		PrintWriter writer = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userService = new UserServiceImpl();
		List<User> list = userService.queryAll();
		boolean flag = userService.login(username, password);
		if(flag) {
			writer.print("<table>");
			writer.print("<tr><th>编号</th><th>用户名</th><th>密码</th><tr>");
			for(User user: list) {
				writer.print("<tr><td>"+user.getId()+"</td><td>"+user.getUsername()+"</td><td>"+user.getPassword()+"</td><tr>");
			}
			writer.print("</table>");
		}else {
			writer.print("<h1>登陆失败!</h1>");
		}
	}

}