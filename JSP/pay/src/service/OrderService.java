package service;

import java.util.List;

import entity.Order;

public interface OrderService {
	public void addOrder(Long order_id, Integer product_id, String product_name, Double product_price, Integer admin_id);
	public List<Order> selectOrder(String condition, String value);
}
