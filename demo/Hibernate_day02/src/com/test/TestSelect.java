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
			session = HibernateUtil.getCurrentSession();//使用本地线程绑定的session
			transaction = session.beginTransaction();//查询不涉及事务，但若使用本地线程绑定的session需使用事务
			
			//创建Query对象
			Query query = session.createQuery("from Student");
			//调用Query对象里的方法得到结果
			List<Student> list = query.list();
			for(Student student: list) {
				System.out.println(student);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			//session.close();//与本地线程绑定的Session 最后不用手动关闭，当线程执行结束后，Session将会自动关闭。如果手动关闭，将报错
		}
	}
	
	@Test
	public void testCriteria() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();//使用本地线程绑定的session
			transaction = session.beginTransaction();//查询不涉及事务，但若使用本地线程绑定的session需使用事务
			//session = HibernateUtil.getSessionFactory().openSession();
			//创建Criteria对象,方法的参数是实体类的class
			Criteria criteria = session.createCriteria(Student.class);
			//调用Criteria对象里的方法得到结果
			List<Student> list = criteria.list();
			for(Student student: list) {
				System.out.println(student);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			//session.close();//与本地线程绑定的Session 最后不用手动关闭，当线程执行结束后，Session将会自动关闭。如果手动关闭，将报错
		}
	}
	@Test
	public void testSQLQuery() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();//使用本地线程绑定的session
			transaction = session.beginTransaction();//查询不涉及事务，但若使用本地线程绑定的session需使用事务
			//session = HibernateUtil.getSessionFactory().openSession();
			//创建SQLQuery对象,方法的参数是实体类的class
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_student");
			
			sqlQuery.addEntity(Student.class);//需要添加实体类，否则返回的是Object数组
			List<Student> list = sqlQuery.list();
			for(Student student: list) {
				System.out.println(student);
			}
			
			/*
			List<Object[]> list = sqlQuery.list();//调用SQLQuery对象里的方法得到结果,返回list集合，集合里面的元素以Object数组的形式存在
			for(Object[] obj: list) {
				System.out.println(Arrays.toString(obj));
			}*/
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			//session.close();//与本地线程绑定的Session 最后不用手动关闭，当线程执行结束后，Session将会自动关闭。如果手动关闭，将报错
		}
	}
}
