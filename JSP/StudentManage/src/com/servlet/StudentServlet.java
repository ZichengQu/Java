package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService stuService = new StudentServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
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
		if("/selStudent.do".equals(servletPath)) {
			selAllStudent(request, response);
		}else if("/selStuByPage.do".equals(servletPath)) {
			selStudentByPage(request, response);
		}
	}
	protected void selAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> list = stuService.selAllStudents();
		request.setAttribute("list", list);
		request.getRequestDispatcher("selStudent.jsp").forward(request, response);
	}
	protected void selStudentByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageIndex = request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize = 2;
		List<Student> list = stuService.selStudentByPage(pageIndex, pageSize);
		request.setAttribute("list", list);
		int totalPages = (int) Math.ceil(stuService.selAllStudents().size()/(double)pageSize);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("pageIndex", pageIndex);
		request.getRequestDispatcher("selStudent.jsp").forward(request, response);
	}
}
