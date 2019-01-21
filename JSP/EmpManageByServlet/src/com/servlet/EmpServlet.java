package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpService;
import com.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpServlet
 */
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpService empService = new EmpServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
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
		response.setContentType("text.html,charset=UTF-8");//ÉèÖÃÏìÓ¦µÄ×Ö·û±àÂë
		request.setCharacterEncoding("UTF-8");//ÉèÖÃÇëÇóµÄ×Ö·û±àÂë
		String servletPath = request.getServletPath();// /delEmp.do
		if("/delEmp.do".equals(servletPath)) {
			delEmpById(request, response);
		}
	}
	public void delEmpById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("empno");
		boolean flag = empService.delEmpById(Integer.parseInt(empno));
		if(flag) {
			request.setAttribute("msg", "É¾³ý³É¹¦");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
			response.getWriter().print("<script>alert('É¾³ýÊ§°Ü');location.href='main.jsp'</script>");
		}
		/*
		 * drop table emp; 
		 * create table emp as select * from scott.emp; 
		 * select * from emp;
		 */
	}
}
