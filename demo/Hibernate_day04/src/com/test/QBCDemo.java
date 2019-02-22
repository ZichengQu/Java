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
	//QBC��ѯ����
	@Test
	public void selAllCustomer() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����Criteria����
			Criteria criteria = session.createCriteria(Customer.class);
			//����Criteria���������list�����õ����
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
	//QBC������ѯ: ��ȷ��ѯ
	@Test
	public void selCustomerByCondition() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����Criteria����
			Criteria criteria = session.createCriteria(Customer.class);
			//����Criteria���������add�������ò�ѯ����
			criteria.add(Restrictions.eq("cid", 4));
			criteria.add(Restrictions.eq("custName", "����"));//��ӵ������൱��and���ӣ�or�Ļ������������
			//����Criteria���������list�����õ����
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
	//QBC������ѯ: ģ����ѯ
	@Test
	public void selCustomerByLike() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			// ����Criteria����
			Criteria criteria = session.createCriteria(Customer.class);
			// ����Criteria���������add�������ò�ѯ����
			criteria.add(Restrictions.like("custName", "%��%"));
			// ����Criteria���������list�����õ����
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
	//QBC�����ѯ
	@Test
	public void selCustomerByOrder() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			// ����Criteria����
			Criteria criteria = session.createCriteria(Customer.class);
			// ����Criteria���������addOrder�������ö��ĸ����Խ������������������
			criteria.addOrder(Order.desc("cid"));
			// ����Criteria���������list�����õ����
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
	//QBC��ҳ��ѯ
	@Test
	public void selCustomerByPage() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����Criteria����
			Criteria criteria = session.createCriteria(Customer.class);
			//���÷�ҳ����			
			criteria.setFirstResult(0);//��ʼλ��
			criteria.setMaxResults(3);//ÿҳ��¼��,pageSize
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
	//ͳ�Ʋ�ѯ
	@Test
	public void countCustomer() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����Criteria����
			Criteria criteria = session.createCriteria(Customer.class);
			//����ͳ�Ʋ���
			criteria.setProjection(Projections.rowCount());
			//����Criteria��������ķ����õ����
			Object object = criteria.uniqueResult();
			System.out.println(((Long)object).intValue());//��ת��ΪLong���ͣ�Ȼ��ת��Ϊint����
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * ���߲�ѯ
	 * ��Servlet�и�DetachedCriteria��ֵ�����䴫��dao��ķ������ٿ���session���Criteria���󲢵�����ط�����
	 */
	@Test
	public void outlineSel() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//1.����DetachedCriteria������Servlet��д
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
			
			//2.��Servlet��д��������������DetachedCriteria���󴫵��˷�����......
			//criteria.add(Restrictions.eq("cid", 4));
			//criteria.add(Restrictions.like("custName", "%��%"));
			
			//3.�ڴ˷����У�����ִ�е�ʱ�����Ҫ�õ�session,���Criteria����
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
