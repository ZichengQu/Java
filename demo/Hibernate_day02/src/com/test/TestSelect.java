package com.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.pojo.Student;
import com.util.HibernateUtil;

public class TestSelect {
	@Test
	public void testQuery() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();//ʹ�ñ����̰߳󶨵�session
			transaction = session.beginTransaction();//��ѯ���漰���񣬵���ʹ�ñ����̰߳󶨵�session��ʹ������
			
			//����Query����
			Query query = session.createQuery("from Student");
			//����Query������ķ����õ����
			List<Student> list = query.list();
			for(Student student: list) {
				System.out.println(student);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			//session.close();//�뱾���̰߳󶨵�Session ������ֶ��رգ����߳�ִ�н�����Session�����Զ��رա�����ֶ��رգ�������
		}
	}
	
	@Test
	public void testCriteria() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();//ʹ�ñ����̰߳󶨵�session
			transaction = session.beginTransaction();//��ѯ���漰���񣬵���ʹ�ñ����̰߳󶨵�session��ʹ������
			//session = HibernateUtil.getSessionFactory().openSession();
			//����Criteria����,�����Ĳ�����ʵ�����class
			Criteria criteria = session.createCriteria(Student.class);
			//����Criteria������ķ����õ����
			List<Student> list = criteria.list();
			for(Student student: list) {
				System.out.println(student);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			//session.close();//�뱾���̰߳󶨵�Session ������ֶ��رգ����߳�ִ�н�����Session�����Զ��رա�����ֶ��رգ�������
		}
	}
	@Test
	public void testSQLQuery() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();//ʹ�ñ����̰߳󶨵�session
			transaction = session.beginTransaction();//��ѯ���漰���񣬵���ʹ�ñ����̰߳󶨵�session��ʹ������
			//session = HibernateUtil.getSessionFactory().openSession();
			//����SQLQuery����,�����Ĳ�����ʵ�����class
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_student");
			
			sqlQuery.addEntity(Student.class);//��Ҫ���ʵ���࣬���򷵻ص���Object����
			List<Student> list = sqlQuery.list();
			for(Student student: list) {
				System.out.println(student);
			}
			
			/*
			List<Object[]> list = sqlQuery.list();//����SQLQuery������ķ����õ����,����list���ϣ����������Ԫ����Object�������ʽ����
			for(Object[] obj: list) {
				System.out.println(Arrays.toString(obj));
			}*/
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			//session.close();//�뱾���̰߳󶨵�Session ������ֶ��رգ����߳�ִ�н�����Session�����Զ��رա�����ֶ��رգ�������
		}
	}
}
