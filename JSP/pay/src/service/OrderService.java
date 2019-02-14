package service;

import java.util.List;

import entity.Order;

public interface OrderService {
	public Boolean addOrder(Order order);
	public List<Order> selectOrderByCondition(String condition, String value);
	public Boolean deleteOrder(String orderId);
	public Order selectOrderById(Long order_id);
}
