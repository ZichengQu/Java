package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import dao.OrderDao;
import entity.Order;
import javafx.css.PseudoClass;
import util.DBUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Boolean addOrder(Order order) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into order_info values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, order.getOrder_id());
		ps.setInt(2, order.getProduct_id());
		ps.setString(3, order.getProduct_name());
		ps.setInt(4,order.getAdmin_id());
		ps.setDouble(5,order.getProduct_price());
		Boolean flag = ps.executeUpdate()!=0?true:false;
		DBUtil.close(conn, ps, null);
		return flag;
	}

	@Override
	public List<Order> selectOrderByCondition(String condition, String value) throws Exception {
		List<Order> list = new ArrayList<Order>();
		Connection conn = DBUtil.getConnection();
		//String sql = "select * from order_info where "+condition+" like '%"+value+"%'";
		String sql = "select * from order_info where "+condition+" like ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		//ps.setString(1, "condition");//不能将condition赋成String的值，否则会查询不到结果。
		ps.setString(1, "%"+value+"%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			list.add(
				new Order(	rs.getLong("order_id"), 
							rs.getInt("product_id"), 
							rs.getString("product_name"),
							rs.getDouble("product_price"),
							rs.getInt("admin_id"))
					);
		}
		if(list!=null) {
			System.out.println(list);
			System.out.println("OrderDaoImpl的selectOrderByCondition里的list的size: "+list.size());
		}
		DBUtil.close(conn, ps, rs);
		return list;
	}

	@Override
	public Boolean deleteOrder(String orderId) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from order_info where order_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, Long.parseLong(orderId));
		Boolean flag = ps.executeUpdate()!=0?true:false;
		DBUtil.close(conn, ps, null);
		return flag;
	}

	@Override
	public Order selectOrderById(Long order_id) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from order_info where order_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, order_id);
		ResultSet rs = ps.executeQuery();
		Order order = null;
		while (rs.next()) {
			order = new Order(	rs.getLong("order_id"), 
							rs.getInt("product_id"), 
							rs.getString("product_name"),
							rs.getDouble("product_price"),
							rs.getInt("admin_id"));
		}
		DBUtil.close(conn, ps, rs);
		return order;
	}
}
