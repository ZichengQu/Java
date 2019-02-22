package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bean.Customer;
import com.bean.LinkMan;
import com.bean.Role;
import com.bean.User;
import com.util.HibernateUtil;

public class ManyToManyTest {
	@Test
	public void add() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			//添加两个用户，为每个用户添加两个角色
			User user1 = new User();
			User user2 = new User();
			user1.setUsername("name1");
			user1.setPassword("密码1");
			user2.setUsername("name2");
			user2.setPassword("密码2");
			Role role1 = new Role();
			Role role2 = new Role();
			Role role3 = new Role();
			role1.setRname("role1");
			role1.setRdesc("描述1");
			role2.setRname("role2");
			role2.setRdesc("描述2");
			role3.setRname("role3");
			role3.setRdesc("描述3");
			
			user1.getRoleSet().add(role1);
			user1.getRoleSet().add(role2);
			user2.getRoleSet().add(role2);
			user2.getRoleSet().add(role3);
			
			session.save(user1);
			session.save(user2);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Test
	public void delete() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			
			User user = session.get(User.class, 1);
			session.delete(user);//删除user，同时会将user1所对应的所有role都删除(即使role不只依靠于user1)
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Test
	public void addRoleForUser() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			
			//根据id查询用户和角色
			User user = session.get(User.class, 2);
			Role role4 = session.get(Role.class, 4);
			//把角色放到用户的set集合里面
			user.getRoleSet().add(role4);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Test
	public void removeRoleFromUser() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			
			//根据id查询用户和角色
			User user = session.get(User.class, 2);
			Role role4 = session.get(Role.class, 4);
			//从用户的set集合里面把角色移除
			user.getRoleSet().remove(role4);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
