package com.dao;

import java.util.List;

import com.bean.Customer;

public interface CustomerDao {
	public boolean add(Customer customer);
	public List<Customer> query();
	public boolean deleteCustomer(int customer_cid);
}
