package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstAnnotationDemo
 */
@WebServlet(name = "/FirstAnnotationDemo", /* name:默认是当前类的全限定名 */
			urlPatterns= {"/first","/second"},
			loadOnStartup = 1,
		initParams = { /* 当前Servlet的初始化参数(局部初始化参数)，用this.getServletConfig().getInitParameter("name_1")获取参数的value值 */
					@WebInitParam(name="name_1",value="value_1"),
					@WebInitParam(name="name_2",value="value_2")
			}
		)
public class FirstAnnotationDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstAnnotationDemo() {
        super();
        System.out.println("构造函数");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...");
		String name_1 = this.getServletConfig().getInitParameter("name_1");
		System.out.println(name_1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
