package com.test;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bean.Customer;
import com.bean.LinkMan;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.util.HibernateUtil;

public class HQLDemo {
	//HQL��ѯ���У���ѯ���пͻ���Ϣ
	@Test
	public void selAllCustomer() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����Query����дhql���
			Query query = session.createQuery("from Customer");
			//����query��������ķ����õ����
			List<Customer> list = query.list();
			for(Customer customer:list) { 
				//Customer����linkMan��toString��LinkMan��customer��ͬString��������ѭ������������ڴ������������Ҫɾ��������һ��;
				System.out.println(customer); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//HQL������ѯ: ����һ����ȷ��ѯ
	@Test
	public void selCustomerByCondition() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����Query����дhql���
			Query query = session.createQuery("from Customer c where c.cid = ? and c.custName = ?");//����ʹ��ʹ�ö�����
			//���ò�ѯ����
			query.setParameter(0, 4);//hql�е�ռλ���Ǵ�0��ʼ�ģ�sql��ռλ���Ǵ�1��ʼ��
			query.setParameter(1, "����");
			//����query���������list�����õ����
			List<Customer> list = query.list();
			for(Customer customer:list) { 
				//Customer����linkMan��toString��LinkMan��customer��ͬString��������ѭ������������ڴ������������Ҫɾ��������һ��;
				System.out.println(customer); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//HQL������ѯ: ��������ģ����ѯ
	@Test
	public void selCustomerByLikeName() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����Query����дhql���
			Query query = session.createQuery("from Customer c where c.custName like ?");//����ʹ��ʹ�ö�����
			//���ò�ѯ����
			query.setParameter(0, "%��%");//hql�е�ռλ���Ǵ�0��ʼ�ģ�sql��ռλ���Ǵ�1��ʼ��
			//����query���������list�����õ����
			List<Customer> list = query.list();
			for(Customer customer:list) { 
				//Customer����linkMan��toString��LinkMan��customer��ͬString��������ѭ������������ڴ������������Ҫɾ��������һ��;
				System.out.println(customer); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//HQL�����ѯ
	@Test
	public void selCustomerByOrder() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����Query����дhql���
			Query query = session.createQuery("from Customer c order by c.cid desc");//����ʹ��ʹ�ö�����
			//����query���������list�����õ����
			List<Customer> list = query.list();
			for(Customer customer:list) { 
				//Customer����linkMan��toString��LinkMan��customer��ͬString��������ѭ������������ڴ������������Ҫɾ��������һ��;
				System.out.println(customer); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * HQL��ҳ��ѯ:
	 * 	mysqlʵ�֣�ʹ��limitʵ�֣�����hql����ﲻ��дlimit��hibernate��Query�����װ����������ʵ�ַ�ҳ����
	 * 	mysql��ҳ��ѯ���ʽ: select * from emp limit 4,3;//��ʼ��=(ҳ������-1)*ҳ��С; ҳ��С=ҳ��С;
	 * 	oracleҲʹ����ͼ���룬ֻ������ҳ��Ϳ�ʼλ�ö�Ӧ�ı��ʽ��һ��: start=(page-1)pageSize+1; end=pageSize*page;
	 */
	@Test
	public void selCustomerByPage() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����Query����дhql���
			Query query = session.createQuery("from Customer");
			//���÷�ҳ����
			query.setFirstResult(1);//���ÿ�ʼλ�ã���һ�����ݴ�0��ʼ��//ʵ�ʿ������Ǵ�ҳ�룻��ʼλ�ü��㹫ʽ������ǰҳ-1��*ÿҳ��¼����
			query.setMaxResults(3);//����ÿҳ��¼��
			//����query���������list�����õ����
			List<Customer> list = query.list();
			for(Customer customer:list) { 
				//Customer����linkMan��toString��LinkMan��customer��ͬString��������ѭ������������ڴ������������Ҫɾ��������һ��;
				System.out.println(customer); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * HQLͶӰ��ѯ:
	 * select ʵ������������1,ʵ������������2 from ʵ��������
	 * select ����д*,��Ϊ��֧��
	 */
	@Test
	public void selCustomerByField() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����Query����дhql���
			Query query = session.createQuery("select cid,custName from Customer");//����ֻ��һ�����ԣ�list���Ͼ���Object���գ�������Object����
			//����query���������list�����õ����
			List<Object[]> list = query.list();//���ﲻ�ܷ�װ������Ϊquery��list������ȡ�������ԣ����Ƕ���;
			for(Object[] object:list) { 
				//Customer����linkMan��toString��LinkMan��customer��ͬString��������ѭ������������ڴ������������Ҫɾ��������һ��;
				
				System.out.println(Arrays.toString(object)); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * �ۼ�������ʹ��
	 * count()/sum()/avg()/max()/min()
	 * select count(*) from Customer;
	 */
	@Test
	public void countCustomer() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//����Query����дhql���
			Query query = session.createQuery("select count(*) from Customer");
			//����query���������uniqueResult�����õ����
			Object count = query.uniqueResult();//Count�������صĽ������ʹ��Object��Long(ʵ������Long����)�������ݽ���;
			//��һ�е��������ᱨ����Ϊʵ�ʷ��ص�Object��һ��Lang���͵�����;java.lang.Long cannot be cast to java.lang.Integer
			//System.out.println((Integer)count);
			System.out.println(((Long)count).intValue());//Ӧ��ת����Long���ͣ���ת����int����;
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * HQL�����Ӳ�ѯ�﷨��(�Կͻ�����ϵ��Ϊ��)
	 * from Customer c inner join c.setLinkMan	//�������𶼿���	//Ҫ��c.setLinkMan(��ΪCustomer�Ѿ����������)��дLinkMan�����ᱨ��
	 */
	@Test
	public void innerJoin() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Customer c inner join c.setLinkMan");
			List<Object[]> list = query.list();
			for(Object[] objects:list) {
				System.out.println(Arrays.toString(objects));
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 *HQL����������
	   * ʹ��fetchʱ��֪ͨhibernate����һ����������ݷ�װ���ö�����(����ϵ�˵����ݷ�װ��Customer������)
	 */
	@Test
	public void innerJoinFetch() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");
			List<Customer> list = query.list();//ʹ��fetchʱ��֪ͨhibernate����һ����������ݷ�װ���ö�����(����ϵ�˵����ݷ�װ��Customer������)
			for(Customer customer:list) {
				System.out.println(customer);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * HQL��������
	 * from Customer c left join c.setLinkMan
	 */
	@Test
	public void leftOuterJoin() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Customer c left join c.setLinkMan");
			List<Object[]> list = query.list();
			for(Object[] objects:list) {
				System.out.println(Arrays.toString(objects));
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * HQL������������
	 * from Customer c left join fetch c.setLinkMan
	 */
	@Test
	public void leftOuterJoinFetch() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Customer c left join fetch c.setLinkMan");
			List<Customer> list = query.list();//ʹ��fetchʱ��֪ͨhibernate����һ����������ݷ�װ���ö�����(����ϵ�˵����ݷ�װ��Customer������)
			for(Customer customer:list) {
				System.out.println(customer);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * HQL��������
	 * from Customer c right join c.setLinkMan
	 */
	@Test
	public void rightOuterJoin() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Customer c right join c.setLinkMan");
			List<Object[]> list = query.list();
			for(Object[] objects:list) {
				System.out.println(Arrays.toString(objects));
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
