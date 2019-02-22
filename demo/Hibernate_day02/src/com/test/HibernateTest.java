package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.pojo.Student;
import com.util.HibernateUtil;

public class HibernateTest {
	@Test
	public void testSave() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			
			Student student = new Student();
			//student.setSid("100");
			student.setSname("ѧ��");
			student.setProject("java");
			student.setScore(100);
			session.save(student);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			//session.close();//�뱾���̰߳󶨵�Session ������ֶ��رգ����߳�ִ�н�����Session�����Զ��رա�����ֶ��رգ�������
		}
	}
	
	@Test
	public void testGet() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = session.get(Student.class, 1);//����session�����get����
		System.out.println(student);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testUpdate() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
	   //1.��һ��
		//1.����id��ѯ
		Student student = session.get(Student.class, 4);//����session�����get����
		//2.�򷵻صĶ������������޸�֮���ֵ
		student.setSname("idΪ4��ѧ��");
		//session.update(student);//���ݿ��д�������δ�޸ĵĲ��ֱ���ԭֵ����;һ����������ԣ��־�̬���Զ��������ݿ⣬��ʱ���㲻ʹ��update����Ҳ�����Զ��������ݿ⡣
		
	   //2.�ڶ���
		/*
		Student student = new Student();
		student.setSid(5);
		student.setSname("name");
		session.update(student);//���ݿ���ֻ��id��name��ֵ������ȫΪ��
		*/
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testDelete() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		/*��һ�ַ���*/
		Student student1 = session.get(Student.class, 1);//����session�����get����
		session.delete(student1);
		/*�ڶ��ַ���*/
		Student student2 = new Student();
		student2.setSid(3);
		session.delete(student2);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testSaveOrUpdate() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setSname("SaveOrUpdate1");
		student.setProject("project");
		student.setScore(100);
		//1.ʵ�������״̬��˲ʱ̬������Ӳ���
		//session.saveOrUpdate(student);
		//2.ʵ�������������̬��־�̬�����޸Ĳ���
		student.setSid(6);//����д6����Ϊ�����ݿ����������ݵ�id��6
		student.setSname("SaveOrUpdate2");
		session.saveOrUpdate(student);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testCache() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student1 = session.get(Student.class, 4);//����session�����get����
		System.out.println(student1);
		//session.clear();//�������һ������
		session.evict(student1);//���ָ������
		Student student2 = session.get(Student.class, 4);
		System.out.println(student2);
		
		System.out.println(student1==student2);//false,��Ϊ�������������ԣ����Ƕ��󣬵��ڶ��β�ѯʱ���Ὣ��Щ�������һ���µĶ���
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
