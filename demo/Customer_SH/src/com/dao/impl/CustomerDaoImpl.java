package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Customer;
import com.dao.CustomerDao;
import com.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public boolean add(Customer customer) {
		Session session=null;
		Transaction tx=null;
		boolean flag = false;
		try{
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			session.save(customer);
			tx.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Customer> query() {
		List<Customer> list=new ArrayList<Customer>();
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(Customer.class);
			list = criteria.list();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}

	@Override
	public boolean deleteCustomer(int customer_cid) {
		Session session=null;
		Transaction tx=null;
		boolean flag = false;
		try{
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			Customer customer = session.get(Customer.class, customer_cid);
			session.delete(customer);
			tx.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			flag = false;
		}
		return flag;
	}

}
