package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bean.Customer;
import com.bean.LinkMan;
import com.util.HibernateUtil;

public class OneToManyTest {
	//һ�Զ�ļ�������,����д��
	@Test
	public void testAdd() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//1.�����ͻ�����ϵ�˶���
			Customer customer = new Customer();
			customer.setCustName("��Ѷ");
			customer.setCustLevel("��ͨ�ͻ�");
			customer.setCustSource("����");
			customer.setCustPhone("123456");
			customer.setCustMobile("14712345678");
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("��ϵ��1");
			linkMan.setLkm_gender("��");
			linkMan.setLkm_phone("10086");
			/*
			 * 2. �ڿͻ��б�ʾ������ϵ�ˣ�����ϵ���б�ʾ�����ͻ��������ͻ��������ϵ�˶���Ĺ�ϵ��
			 * 2.1 ����ϵ�˶���ŵ��ͻ������set��������
			 * 2.2 �ѿͻ�����ŵ���ϵ������
			 */
			customer.getSetLinkMan().add(linkMan);
			linkMan.setCustomer(customer);
			//3.�������ݵ����ݿ�
			session.save(customer);
			session.save(linkMan);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//һ�Զ�ļ�������,��д������Ҫ����Customer.hbm.xml�����cascade����
	@Test
	public void testAddByCascade() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//1.�����ͻ�����ϵ�˶���
			Customer customer = session.get(Customer.class, 1);//��ȡ��testAdd(����д��)�е���Ѷ�ͻ�

			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("��ϵ��2");
			linkMan.setLkm_gender("Ů");
			linkMan.setLkm_phone("10010");

			//2.����ϵ�˶���ŵ��ͻ������set��������
			customer.getSetLinkMan().add(linkMan);//customer��inverse����Ϊtrue������customer�������ά��Ȩ֮�󣬲��ܹ�Ϊ��ϵ��������
			//3.�������ݵ����ݿ�
			session.saveOrUpdate(customer);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//һ�Զ�ļ���ɾ������д������Ҫ����Customer.hbm.xml�����cascade����
	@Test
	public void testDeleteByCascade() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//1.����id��ѯ�ͻ�����
			Customer customer = session.get(Customer.class, 1);//��ȡ��testAdd(����д��)�е���Ѷ�ͻ�
			//2.���÷���ɾ��
			session.delete(customer);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//һ�Զ�ļ����޸ģ���д������Ҫ����Customer.hbm.xml�����cascade����
		@Test
		public void testUpdateByCascade() {
			Session session = null;
			Transaction transaction = null;
			try {
				session = HibernateUtil.getCurrentSession();
				transaction = session.beginTransaction();
				//1.����id��ѯ�ͻ�����
				Customer customer = session.get(Customer.class, 5);//��ȡ��testAdd(����д��)�е����׿ͻ�,����idΪ4
				LinkMan linkMan = session.get(LinkMan.class, 7);//������Ѷ����ϵ��
				linkMan.setCustomer(customer);
				customer.getSetLinkMan().add(linkMan);//��debug���е�ʱ�򣬻���Ϊcustomer.getSetLinkMan()������ȥ��ѯ���µĵ�����select���
				
				transaction.commit();//���ύ��ʱ�򣬻Ὣһ������Ϳ��������жԱȣ�Ȼ��������ݡ�
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		}
		
}
