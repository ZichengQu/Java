package service.impl;

import java.util.List;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import entity.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao oDao = new OrderDaoImpl();
	@Override
	public void addOrder(Long order_id, Integer product_id, String product_name, Double product_price, Integer admin_id) {
		try {
			oDao.addOrder(order_id, product_id, product_name, product_price, admin_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Order> selectOrder(String condition, String value) {
		List<Order> list = null;
		try {
			list = oDao.selectOrder(condition, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
