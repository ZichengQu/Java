package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.OrderDao;
import entity.Order;
import util.HibernateUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean addOrder(Order order){
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			session.save(order);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			transaction.rollback();
			flag = false;
			e.printStackTrace();
		}
			return flag;
	}

	@Override
	public List<Order> selectOrderByCondition(String condition, String value){
		Session session = null;
		Transaction transaction = null;
		List<Order> list = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Order where "+condition+" like ?");
			//Query query = session.createQuery("from Order where ? like ?");//这样写不好使，只能用condition去拼接字符串。JDBC和Hibernate中均不好使。
			//query.setParameter(0, condition);
			query.setParameter(0, "%"+value+"%");
			list = query.list();
			transaction.commit();
		} catch (Exception e) {
			System.out.println(111);
			transaction.rollback();
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteOrder(String orderId){	
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			Order order = session.get(Order.class, orderId);
			session.delete(order);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			transaction.rollback();
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Order selectOrderById(Long order_id){
		Session session = null;
		Transaction transaction = null;
		Order order = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			order = session.get(Order.class, order_id);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return order;
	}
}
