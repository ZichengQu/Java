package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import entity.Order;
import javafx.css.PseudoClass;
import util.DBUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void addOrder(Long order_id, Integer product_id, String product_name, Double product_price, Integer admin_id) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into order_info values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, order_id);
		ps.setInt(2, product_id);
		ps.setString(3, product_name);
		ps.setInt(4, admin_id);
		ps.setDouble(5, product_price);
		ps.executeUpdate();
		DBUtil.close(conn, ps, null);
	}

	@Override
	public List<Order> selectOrder(String condition, String value) throws Exception {
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
			System.out.println("jinliale");
		}
		return list;
	}

}
