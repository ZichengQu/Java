package com.service;

import org.springframework.transaction.annotation.Transactional;

import com.dao.OrderDao;
@Transactional
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	//����dao����ķ�����дҵ���߼���ʵ��ת�˲���
	public void account(){
		orderDao.lessMoney();
		//int i=10/0;
		orderDao.moreMoney();
	}
	
	
	
}
