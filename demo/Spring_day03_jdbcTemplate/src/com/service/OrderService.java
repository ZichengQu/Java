package com.service;

import org.springframework.transaction.annotation.Transactional;

import com.dao.OrderDao;
@Transactional
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	//调用dao里面的方法，写业务逻辑，实现转账操作
	public void account(){
		orderDao.lessMoney();
		//int i=10/0;
		orderDao.moreMoney();
	}
	
	
	
}
