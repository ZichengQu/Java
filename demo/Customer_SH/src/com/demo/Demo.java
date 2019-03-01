package com.demo;
import java.util.List;

import com.bean.Customer;
import com.dao.CustomerDao;
import com.dao.impl.CustomerDaoImpl;

public class Demo {
	public static void main(String[] args) {
		CustomerDao cDao=new CustomerDaoImpl();
		List<Customer> list = cDao.query();
		System.out.println(list);
	}
}
