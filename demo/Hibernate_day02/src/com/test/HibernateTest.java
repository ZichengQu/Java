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
			student.setSname("学生");
			student.setProject("java");
			student.setScore(100);
			session.save(student);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			//session.close();//与本地线程绑定的Session 最后不用手动关闭，当线程执行结束后，Session将会自动关闭。如果手动关闭，将报错
		}
	}
	
	@Test
	public void testGet() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = session.get(Student.class, 1);//调用session里面的get方法
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
		
	   //1.第一种
		//1.根据id查询
		Student student = session.get(Student.class, 4);//调用session里面的get方法
		//2.向返回的对象里面设置修改之后的值
		student.setSname("id为4的学生");
		//session.update(student);//数据库中此条数据未修改的部分保留原值不变;一级缓存的特性：持久态会自动更新数据库，此时就算不使用update方法也可以自动更新数据库。
		
	   //2.第二种
		/*
		Student student = new Student();
		student.setSid(5);
		student.setSname("name");
		session.update(student);//数据库中只有id和name有值，其它全为空
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
		/*第一种方法*/
		Student student1 = session.get(Student.class, 1);//调用session里面的get方法
		session.delete(student1);
		/*第二种方法*/
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
		//1.实体类对象状态是瞬时态，做添加操作
		//session.saveOrUpdate(student);
		//2.实体类对象是游离态或持久态，做修改操作
		student.setSid(6);//这里写6是因为在数据库中这条数据的id是6
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
		
		Student student1 = session.get(Student.class, 4);//调用session里面的get方法
		System.out.println(student1);
		//session.clear();//清空所有一级缓存
		session.evict(student1);//清除指定对象
		Student student2 = session.get(Student.class, 4);
		System.out.println(student2);
		
		System.out.println(student1==student2);//false,因为缓存里存的是属性，不是对象，当第二次查询时，会将这些属性组成一个新的对象
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
