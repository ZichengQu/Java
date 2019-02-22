package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bean.Customer;
import com.bean.LinkMan;
import com.util.HibernateUtil;

public class OneToManyTest {
	//一对多的级联保存,复杂写法
	@Test
	public void testAdd() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//1.创建客户和联系人对象
			Customer customer = new Customer();
			customer.setCustName("腾讯");
			customer.setCustLevel("普通客户");
			customer.setCustSource("网络");
			customer.setCustPhone("123456");
			customer.setCustMobile("14712345678");
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("联系人1");
			linkMan.setLkm_gender("男");
			linkMan.setLkm_phone("10086");
			/*
			 * 2. 在客户中表示所有联系人，在联系人中表示所属客户；建立客户对象和联系人对象的关系；
			 * 2.1 把联系人对象放到客户对象的set集合里面
			 * 2.2 把客户对象放到联系人里面
			 */
			customer.getSetLinkMan().add(linkMan);
			linkMan.setCustomer(customer);
			//3.保存数据到数据库
			session.save(customer);
			session.save(linkMan);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//一对多的级联保存,简化写法；需要先在Customer.hbm.xml里进行cascade配置
	@Test
	public void testAddByCascade() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//1.创建客户和联系人对象
			Customer customer = session.get(Customer.class, 1);//获取到testAdd(复杂写法)中的腾讯客户

			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("联系人2");
			linkMan.setLkm_gender("女");
			linkMan.setLkm_phone("10010");

			//2.把联系人对象放到客户对象的set集合里面
			customer.getSetLinkMan().add(linkMan);//customer的inverse不能为true，否则customer放弃外键维护权之后，不能够为联系人添加外键
			//3.保存数据到数据库
			session.saveOrUpdate(customer);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//一对多的级联删除，简化写法；需要先在Customer.hbm.xml里进行cascade配置
	@Test
	public void testDeleteByCascade() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//1.根据id查询客户对象
			Customer customer = session.get(Customer.class, 1);//获取到testAdd(复杂写法)中的腾讯客户
			//2.调用方法删除
			session.delete(customer);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	//一对多的级联修改，简化写法；需要先在Customer.hbm.xml里进行cascade配置
		@Test
		public void testUpdateByCascade() {
			Session session = null;
			Transaction transaction = null;
			try {
				session = HibernateUtil.getCurrentSession();
				transaction = session.beginTransaction();
				//1.根据id查询客户对象
				Customer customer = session.get(Customer.class, 5);//获取到testAdd(复杂写法)中的网易客户,现在id为4
				LinkMan linkMan = session.get(LinkMan.class, 7);//这是腾讯的联系人
				linkMan.setCustomer(customer);
				customer.getSetLinkMan().add(linkMan);//用debug运行的时候，会因为customer.getSetLinkMan()方法而去查询如下的第三个select语句
				
				transaction.commit();//当提交的时候，会将一级缓存和快照区进行对比，然后更新数据。
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		}
		
}
