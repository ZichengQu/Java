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
	//HQL查询所有：查询所有客户信息
	@Test
	public void selAllCustomer() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//创建Query对象，写hql语句
			Query query = session.createQuery("from Customer");
			//调用query对象里面的方法得到结果
			List<Customer> list = query.list();
			for(Customer customer:list) { 
				//Customer中有linkMan的toString，LinkMan有customer的同String，会无限循环，会产生堆内存溢出，所以需要删除掉其中一个;
				System.out.println(customer); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//HQL条件查询: 方法一，精确查询
	@Test
	public void selCustomerByCondition() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//创建Query对象，写hql语句
			Query query = session.createQuery("from Customer c where c.cid = ? and c.custName = ?");//别名使不使用都可以
			//设置查询条件
			query.setParameter(0, 4);//hql中的占位符是从0开始的；sql的占位符是从1开始的
			query.setParameter(1, "网易");
			//调用query对象里面的list方法得到结果
			List<Customer> list = query.list();
			for(Customer customer:list) { 
				//Customer中有linkMan的toString，LinkMan有customer的同String，会无限循环，会产生堆内存溢出，所以需要删除掉其中一个;
				System.out.println(customer); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//HQL条件查询: 方法二，模糊查询
	@Test
	public void selCustomerByLikeName() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//创建Query对象，写hql语句
			Query query = session.createQuery("from Customer c where c.custName like ?");//别名使不使用都可以
			//设置查询条件
			query.setParameter(0, "%网%");//hql中的占位符是从0开始的；sql的占位符是从1开始的
			//调用query对象里面的list方法得到结果
			List<Customer> list = query.list();
			for(Customer customer:list) { 
				//Customer中有linkMan的toString，LinkMan有customer的同String，会无限循环，会产生堆内存溢出，所以需要删除掉其中一个;
				System.out.println(customer); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//HQL排序查询
	@Test
	public void selCustomerByOrder() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//创建Query对象，写hql语句
			Query query = session.createQuery("from Customer c order by c.cid desc");//别名使不使用都可以
			//调用query对象里面的list方法得到结果
			List<Customer> list = query.list();
			for(Customer customer:list) { 
				//Customer中有linkMan的toString，LinkMan有customer的同String，会无限循环，会产生堆内存溢出，所以需要删除掉其中一个;
				System.out.println(customer); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * HQL分页查询:
	 * 	mysql实现，使用limit实现，但是hql语句里不能写limit，hibernate的Query对象封装了两个方法实现分页操作
	 * 	mysql分页查询表达式: select * from emp limit 4,3;//起始行=(页的索引-1)*页大小; 页大小=页大小;
	 * 	oracle也使用下图代码，只不过是页码和开始位置对应的表达式不一样: start=(page-1)pageSize+1; end=pageSize*page;
	 */
	@Test
	public void selCustomerByPage() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//创建Query对象，写hql语句
			Query query = session.createQuery("from Customer");
			//设置分页数据
			query.setFirstResult(1);//设置开始位置，第一条数据从0开始；//实际开发中是传页码；开始位置计算公式：（当前页-1）*每页记录数；
			query.setMaxResults(3);//设置每页记录数
			//调用query对象里面的list方法得到结果
			List<Customer> list = query.list();
			for(Customer customer:list) { 
				//Customer中有linkMan的toString，LinkMan有customer的同String，会无限循环，会产生堆内存溢出，所以需要删除掉其中一个;
				System.out.println(customer); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * HQL投影查询:
	 * select 实体类属性名称1,实体类属性名称2 from 实体类名称
	 * select 不能写*,因为不支持
	 */
	@Test
	public void selCustomerByField() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//创建Query对象，写hql语句
			Query query = session.createQuery("select cid,custName from Customer");//若是只有一个属性，list集合就用Object接收，而不是Object数组
			//调用query对象里面的list方法得到结果
			List<Object[]> list = query.list();//这里不能封装对象，因为query的list方法获取的是属性，不是对象;
			for(Object[] object:list) { 
				//Customer中有linkMan的toString，LinkMan有customer的同String，会无限循环，会产生堆内存溢出，所以需要删除掉其中一个;
				
				System.out.println(Arrays.toString(object)); 
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * 聚集函数的使用
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
			//创建Query对象，写hql语句
			Query query = session.createQuery("select count(*) from Customer");
			//调用query对象里面的uniqueResult方法得到结果
			Object count = query.uniqueResult();//Count函数返回的结果必须使用Object或Long(实际上是Long类型)类型数据接收;
			//下一行的输出代码会报错，因为实际返回的Object是一个Lang类型的数据;java.lang.Long cannot be cast to java.lang.Integer
			//System.out.println((Integer)count);
			System.out.println(((Long)count).intValue());//应先转换成Long类型，再转换成int类型;
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	/*
	 * HQL内连接查询语法：(以客户和联系人为例)
	 * from Customer c inner join c.setLinkMan	//别名起不起都可以	//要用c.setLinkMan(因为Customer已经关联了外键)，写LinkMan类名会报错
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
	 *HQL迫切内连接
	   * 使用fetch时会通知hibernate将另一个对象的数据封装到该对象中(将联系人的数据封装到Customer对象里)
	 */
	@Test
	public void innerJoinFetch() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");
			List<Customer> list = query.list();//使用fetch时会通知hibernate将另一个对象的数据封装到该对象中(将联系人的数据封装到Customer对象里)
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
	 * HQL左外连接
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
	 * HQL迫切左外连接
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
			List<Customer> list = query.list();//使用fetch时会通知hibernate将另一个对象的数据封装到该对象中(将联系人的数据封装到Customer对象里)
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
	 * HQL右外连接
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
