package service.impl;

import java.util.List;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import entity.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao oDao = new OrderDaoImpl();
	@Override
	public Boolean addOrder(Order order) {
		Boolean flag = false;
		try {
			flag = oDao.addOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Order> selectOrderByCondition(String condition, String value) {
		List<Order> list = null;
		try {
			list = oDao.selectOrderByCondition(condition, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Boolean deleteOrder(String orderId) {
		Boolean flag = false;
		try {
			flag = oDao.deleteOrder(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Order selectOrderById(Long order_id) {
		Order order = null;
		try {
			order = oDao.selectOrderById(order_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

}
