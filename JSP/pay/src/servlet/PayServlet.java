package servlet;

import java.io.IOException;
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
			selectAdminByAP(request, response);
		}else if("/addOrder.do".equals(servletPath)) {
			addOrder(request, response);
		}else if("/QueryServlet.do".equals(servletPath)) {
			QueryServlet(request, response);
		}
	}

	private void selectAdminByAP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminCode = request.getParameter("adminCode");
		String password = request.getParameter("password");
		Admin admin = aService.selectAdminByAP(adminCode, password);
		if(admin!=null) {
			request.getSession().setAttribute("admin", admin);
			response.sendRedirect("index.jsp");
		}else {
			request.getSession().setAttribute("msg", "√‹¬Î¥ÌŒÛ");
			request.getRequestDispatcher("log.jsp").forward(request, response);
		}
		
	}
	private void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("pcode")!=null&&!"".equals(request.getParameter("pcode"))) {
			Long order_id = Long.parseLong(request.getParameter("pcode")); 
			Integer product_id = 1; String product_name = request.getParameter("pname"); 
			Double product_price = Double.parseDouble(request.getParameter("pprice")); 
			Admin admin = (Admin)request.getSession().getAttribute("admin"); 
			Integer admin_id = admin.getAdminId(); 
			oService.addOrder(order_id, product_id, product_name, product_price, admin_id); 
			response.sendRedirect("order.jsp");
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}
	private void QueryServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
		String value = request.getParameter("value");
		List<Order> list = oService.selectOrder(condition, value);
		request.getSession().setAttribute("list", list);
		System.out.println(list);
		System.out.println("test");
		response.sendRedirect("order.jsp");
	}

}
