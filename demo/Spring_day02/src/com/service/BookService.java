package com.service;

import javax.annotation.Resource;

import com.dao.BookDao;
import com.dao.OrdersDao;

public class BookService {
	//得到BookDao和ordersDao的对象
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
