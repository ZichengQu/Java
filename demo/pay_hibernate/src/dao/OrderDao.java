package dao;

import java.util.List;

import entity.Order;

public interface OrderDao {
	public boolean addOrder(Order order);//Boolean - void
	public List<Order> selectOrderByCondition(String condition, String value);
	public boolean deleteOrder(String orderId);//Boolean - void
	public Order selectOrderById(Long order_id);
}
