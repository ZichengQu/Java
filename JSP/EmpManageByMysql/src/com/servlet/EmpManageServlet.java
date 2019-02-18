package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.test.Bean1;

import com.bean.Emp;
import com.bean.PageBean;
import com.service.EmpService;
import com.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpManageServlet
 */
@WebServlet("*.do")
public class EmpManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpManageServlet() {
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
		if("/showEmpByPage.do".equals(servletPath)) {
			showEmpByPage(request,response);
		}
	}

	private void showEmpByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("pageIndex");
		int pageIndex = currentPage==null?1:Integer.parseInt(currentPage);
		int pageSize = 3;
		PageBean pageBean = new PageBean();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalPages = (int) Math.ceil(empService.selAllEmp().size()/(double)pageBean.getPageSize());
		pageBean.setTotalPages(totalPages);
		
		List<Emp> list = empService.selEmpByPage(pageBean);
		
		request.getSession().setAttribute("list", list);
		request.getSession().setAttribute("pageBean", pageBean);
		response.sendRedirect("ShowEmpByPage.jsp");
		
	}

}
