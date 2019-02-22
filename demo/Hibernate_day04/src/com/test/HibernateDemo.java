package com.test;


import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bean.Customer;
import com.bean.LinkMan;
import com.util.HibernateUtil;

public class HibernateDemo {
	//���󵼺���ѯ
	@Test
	public void testSelete1() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����id��ѯĳ���ͻ����ٲ�ѯ����ͻ��������е���ϵ��
			Customer customer = session.get(Customer.class, 4);//OID��ѯ: ����id��ѯһ����¼�����ض��󣻵���session�����get����ʵ��
			Set<LinkMan> linkMans = customer.getSetLinkMan();
			System.out.println(linkMans);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//Hibernate��������: ������ѯ������id��ѯ������get������Ȼ�����Ϸ�������ѯ���ݿ�
	@Test
	public void testGet() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//������ѯ������id��ѯ������get������Ȼ�����Ϸ�������ѯ���ݿ�
			Customer customer = session.get(Customer.class, 4);
			Set<LinkMan> linkMans = customer.getSetLinkMan();
			System.out.println(linkMans);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//Hibernate��������: ����id��ѯ������load�����������Ϸ�������ѯ���ݿ⣬ֻ����Ҫʹ�ö��������ֵ��ʱ�򣬲Żᷢ��������ݿ⣻
	@Test
	public void testLoad() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����load�����������Ϸ�������ѯ���ݿ⣬ֻ����Ҫʹ�ö��������ֵ��ʱ�򣬲Żᷢ��������ݿ�
			//���صĶ�������ֻ��idֵ
			//�õ�����������治��id��ֵ����������ֵ��ʱ��Żᷢ��sql���
			Customer customer = session.load(Customer.class, 4);//���ᷢ��sql���
			System.out.println(customer.getCid());//�����4�������ᷢ��sql���
			System.out.println(customer.getCustName());//�ᷢ��sql�����в�ѯ��Ȼ�󷵻ض�Ӧ��nameֵ
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//����������ӳ�
	@Test
	public void testLazyQuery() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����cid��ѯ�ͻ���Ȼ���ٲ�ѯ����ͻ��������е���ϵ��
			Customer customer = session.get(Customer.class, 4);//lazy=true:�ᷢ��sql���;false:�������в�ѯ���;extra:�ᷢ�����
			Set<LinkMan> linkMans = customer.getSetLinkMan();//lazy=true:���ᷢ��sql���;false:�����Ͳ�ѯ���;extra:���ᷢ�����
			System.out.println(linkMans.size());//lazy=true:�ᷢ�͹��ڲ�ѯlinkMans�����;false:�����Ͳ�ѯ���;extra:�ᷢ��count���
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//����ץȡ
	@Test
	public void batchQuery() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Customer.class);
			//��ѯ���пͻ�
			List<Customer> list = criteria.list();
			//�õ�ÿ���ͻ���������ϵ��
			for(Customer customer:list) {
				System.out.println(customer);
				Set<LinkMan> linkMans = customer.getSetLinkMan();
				for(LinkMan linkMan:linkMans) {
					System.out.println(linkMan);
				}
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
