package com.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
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
		}else if("/addStudent.do".equals(servletPath)) {
			addStudent(request, response);
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
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = Arrays.toString(hobbys);
		System.out.println(hobby);///////////////////////
		String school = request.getParameter("school");
		Date date = new Date();
		Student student = new Student(0,name,hobby.substring(1, hobby.length()-1),school,date);
		stuService.addStudent(student);
		request.setAttribute("msg", "Ìí¼Ó³É¹¦");
		request.getRequestDispatcher("selStuByPage.do").forward(request, response);
		System.out.println(111);
	}
}
