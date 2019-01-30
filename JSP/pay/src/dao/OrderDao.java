package dao;

import java.util.List;

import entity.Order;

public interface OrderDao {
	public void addOrder(Long order_id, Integer product_id, String product_name, Double product_price, Integer admin_id) throws Exception;
	public List<Order> selectOrder(String condition, String value) throws Exception;
}
