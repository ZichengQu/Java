package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import entity.Admin;
import entity.Order;
import service.AdminService;
import service.OrderService;
import service.impl.AdminServiceImpl;
import service.impl.OrderServiceImpl;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("*.do")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminService aService = new AdminServiceImpl();
    OrderService oService = new OrderServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
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
		if("/login.do".equals(servletPath)) {
			selectAdminByCode(request, response);
		}else if("/addOrder.do".equals(servletPath)) {
			addOrder(request, response);
		}else if("/QueryServlet.do".equals(servletPath)) {
			QueryServlet(request, response);
		}else if("/deleteOrder.do".equals(servletPath)) {
			deleteOrder(request, response);
		}else {
			throw new RuntimeException("路径错误......");
		}
	}

	private void selectAdminByCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminCode = request.getParameter("adminCode");
		String password = request.getParameter("password");
		Admin admin = aService.selectAdminByCode(adminCode);
		
		if(admin==null) {
			request.setAttribute("msg", "账号错误");
			request.getRequestDispatcher("log.jsp").forward(request, response);
		}else if(!admin.getPassword().equals(password)){
			request.setAttribute("msg", "密码错误");
			request.getRequestDispatcher("log.jsp").forward(request, response);
		}else if(admin.getPassword().equals(password)) {
			request.getSession().setAttribute("admin", admin);
			response.sendRedirect("index.jsp");
		} 
		
	}
	private void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		Long order_id = Long.parseLong(request.getParameter("pcode")); 
		Integer product_id = Integer.parseInt(request.getParameter("product")); 
		String product_name = request.getParameter("pname"); 
		Double product_price = Double.parseDouble(request.getParameter("pprice")); 
		Admin admin = (Admin)request.getSession().getAttribute("admin"); 
		Integer admin_id = admin.getAdminId(); 
		Order order = new Order(order_id, product_id, product_name, product_price, admin_id);
		if(oService.addOrder(order)) {
			writer.print("<script>alert('添加成功');</script>");
		}else {
			writer.print("<script>alert('添加失败');</script>");
		}
		writer.print("<script>location.href='order.jsp';</script>");//response.sendRedirect("order.jsp");
		
	}
	private void QueryServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
		String value = request.getParameter("value");
		List<Order> list = oService.selectOrderByCondition(condition, value);
		request.getSession().setAttribute("list", list);
		request.getSession().setAttribute("condition", condition);
		request.getSession().setAttribute("value", value);
		response.sendRedirect("order.jsp");
	}
	private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String order_id = request.getParameter("order_id");
		Boolean flag = oService.deleteOrder(order_id);
		
		//order.jsp的Ajax中的$("#search_form").submit()可替换下面四行;否则就算页面重新加载window.location.reload(true)，list数据也不会刷新。
		String condition = (String) request.getSession().getAttribute("condition");
		String value = (String) request.getSession().getAttribute("value");
		List<Order> list = oService.selectOrderByCondition(condition, value);
		request.getSession().setAttribute("list", list);
		
		if(flag) {
			writer.print("true");
		}else{
			writer.print("false");
		}
	}

}
