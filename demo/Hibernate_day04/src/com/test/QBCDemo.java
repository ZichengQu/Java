package com.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.bean.Customer;
import com.bean.LinkMan;
import com.util.HibernateUtil;

public class QBCDemo {
	//QBC查询所有
	@Test
	public void selAllCustomer() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//创建Criteria对象
			Criteria criteria = session.createCriteria(Customer.class);
			//调用Criteria对象里面的list方法得到结果
			List<Customer> list = criteria.list();
			for(Customer customer:list) {
				System.out.println(customer);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//QBC条件查询: 精确查询
	@Test
	public void selCustomerByCondition() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//创建Criteria对象
			Criteria criteria = session.createCriteria(Customer.class);
			//调用Criteria对象里面的add方法设置查询条件
			criteria.add(Restrictions.eq("cid", 4));
			criteria.add(Restrictions.eq("custName", "网易"));//添加的条件相当于and连接，or的话不用这个方法
			//调用Criteria对象里面的list方法得到结果
			List<Customer> list = criteria.list();
			for(Customer customer:list) {
				System.out.println(customer);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//QBC条件查询: 模糊查询
	@Test
	public void selCustomerByLike() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			// 创建Criteria对象
			Criteria criteria = session.createCriteria(Customer.class);
			// 调用Criteria对象里面的add方法设置查询条件
			criteria.add(Restrictions.like("custName", "%网%"));
			// 调用Criteria对象里面的list方法得到结果
			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//QBC排序查询
	@Test
	public void selCustomerByOrder() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			// 创建Criteria对象
			Criteria criteria = session.createCriteria(Customer.class);
			// 调用Criteria对象里面的addOrder方法设置对哪个属性进行排序，设置排序规则
			criteria.addOrder(Order.desc("cid"));
			// 调用Criteria对象里面的list方法得到结果
			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//QBC分页查询
	@Test
	public void selCustomerByPage() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//创建Criteria对象
			Criteria criteria = session.createCriteria(Customer.class);
			//设置分页数据			
			criteria.setFirstResult(0);//开始位置
			criteria.setMaxResults(3);//每页记录数,pageSize
			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//统计查询
	@Test
	public void countCustomer() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//创建Criteria对象
			Criteria criteria = session.createCriteria(Customer.class);
			//设置统计操作
			criteria.setProjection(Projections.rowCount());
			//调用Criteria对象里面的方法得到结果
			Object object = criteria.uniqueResult();
			System.out.println(((Long)object).intValue());//先转换为Long类型，然后转换为int类型
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * 离线查询
	 * 在Servlet中给DetachedCriteria赋值，将其传给dao层的方法，再开启session获得Criteria对象并调用相关方法；
	 */
	@Test
	public void outlineSel() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//1.创建DetachedCriteria对象，在Servlet里写
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
			
			//2.在Servlet里写设置条件，并将DetachedCriteria对象传到此方法中......
			//criteria.add(Restrictions.eq("cid", 4));
			//criteria.add(Restrictions.like("custName", "%网%"));
			
			//3.在此方法中，最终执行的时候才需要用到session,获得Criteria对象
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			
			List<Customer> list = criteria.list();
			for(Customer customer:list) {
				System.out.println(customer);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
}
