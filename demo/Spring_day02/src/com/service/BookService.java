package com.service;

import javax.annotation.Resource;

import com.dao.BookDao;
import com.dao.OrdersDao;

public class BookService {
	//�õ�BookDao��ordersDao�Ķ���
	@Resource(name="bookDao")
	private BookDao bookDao;
	@Resource(name="ordersDao")
	private OrdersDao ordersDao;
	public void add(){
		System.out.println("BookService......");
		bookDao.book();
		ordersDao.buy();
	}
}
