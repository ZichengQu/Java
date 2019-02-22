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
	//对象导航查询
	@Test
	public void testSelete1() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//根据id查询某个客户，再查询这个客户里面所有的联系人
			Customer customer = session.get(Customer.class, 4);//OID查询: 根据id查询一条记录，返回对象；调用session里面的get方法实现
			Set<LinkMan> linkMans = customer.getSetLinkMan();
			System.out.println(linkMans);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//Hibernate检索策略: 立即查询：根据id查询，调用get方法，然后马上发送语句查询数据库
	@Test
	public void testGet() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//立即查询：根据id查询，调用get方法，然后马上发送语句查询数据库
			Customer customer = session.get(Customer.class, 4);
			Set<LinkMan> linkMans = customer.getSetLinkMan();
			System.out.println(linkMans);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//Hibernate检索策略: 根据id查询，调用load方法不会马上发送语句查询数据库，只有需要使用对象里面的值的时候，才会发送语句数据库；
	@Test
	public void testLoad() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//调用load方法不会马上发送语句查询数据库，只有需要使用对象里面的值的时候，才会发送语句数据库
			//返回的对象里面只有id值
			//得到这个对象里面不是id的值，而是其它值的时候才会发送sql语句
			Customer customer = session.load(Customer.class, 4);//不会发送sql语句
			System.out.println(customer.getCid());//会输出4，但不会发送sql语句
			System.out.println(customer.getCustName());//会发送sql语句进行查询，然后返回对应的name值
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//关联级别的延迟
	@Test
	public void testLazyQuery() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//根据cid查询客户，然后再查询这个客户里面所有的联系人
			Customer customer = session.get(Customer.class, 4);//lazy=true:会发送sql语句;false:发送所有查询语句;extra:会发送语句
			Set<LinkMan> linkMans = customer.getSetLinkMan();//lazy=true:不会发送sql语句;false:不发送查询语句;extra:不会发送语句
			System.out.println(linkMans.size());//lazy=true:会发送关于查询linkMans的语句;false:不发送查询语句;extra:会发送count语句
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//批量抓取
	@Test
	public void batchQuery() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Customer.class);
			//查询所有客户
			List<Customer> list = criteria.list();
			//得到每个客户的所有联系人
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
