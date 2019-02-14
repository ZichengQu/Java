package dao;

import java.util.List;

import entity.Order;

public interface OrderDao {
	public Boolean addOrder(Order order) throws Exception;
	public List<Order> selectOrderByCondition(String condition, String value) throws Exception;
	public Boolean deleteOrder(String orderId) throws Exception;
	public Order selectOrderById(Long order_id) throws Exception;
}
