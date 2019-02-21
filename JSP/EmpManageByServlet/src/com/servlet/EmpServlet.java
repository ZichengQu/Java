package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Dept;
import com.bean.Emp;
import com.service.DeptService;
import com.service.EmpService;
import com.service.impl.DeptServiceImpl;
import com.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpServlet
 */
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpService empService = new EmpServiceImpl();
    private DeptService deptService = new DeptServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
        super();
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
		response.setContentType("text/html;charset=UTF-8");//设置响应的字符编码
		request.setCharacterEncoding("UTF-8");//设置请求的字符编码
		String servletPath = request.getServletPath();// /delEmp.do等
		if("/delEmp.do".equals(servletPath)) {
			delEmpById(request, response);
		}else if ("/addEmp.do".equals(servletPath)) {
			addEmp(request, response);
		}else if("/selMgrByDept.do".equals(servletPath)) {
			selMgrByDept(request,response);
		}
	}
	public void delEmpById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("empno");
		boolean flag = empService.delEmpById(Integer.parseInt(empno));
		if(flag) {
			request.getSession().setAttribute("msg", "删除成功");
			response.sendRedirect("main.jsp");
		}else {
			response.getWriter().print("<script>alert('删除失败');location.href='main.jsp'</script>");
		}
		/*
		 * drop table emp; 
		 * create table emp as select * from scott.emp; 
		 * select * from emp;
		 */
	}
	
	 public void addEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		 int empno = Integer.parseInt(request.getParameter("empno")); 
		 String ename = request.getParameter("ename"); 
		 String job = request.getParameter("job"); 
		 int mgr = Integer.parseInt(request.getParameter("mgr")); 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD"); 
		 Date hiredate =  null; 
		 try {
			hiredate = sdf.parse(request.getParameter("hiredate"));
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		 Double sal = Double.parseDouble(request.getParameter("sal")); 
		 Double comm = Double.parseDouble(request.getParameter("comm")); 
		 int deptno = Integer.parseInt(request.getParameter("deptno")); 
		 Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno); 
		 empService.addEmp(emp);
		 //request.getSession().setAttribute("msg", "添加成功");
		 response.sendRedirect("forward.jsp");
	}
	 public void selMgrByDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int deptno = Integer.parseInt(request.getParameter("deptno")); 
		 List<Emp> list = empService.selMgrByDept(deptno);
		 PrintWriter writer = response.getWriter();
		 String list1 = String.valueOf(list);//此处应该将list转为json，并将其传给ajax。
		 writer.print(list1);
	 }
}
