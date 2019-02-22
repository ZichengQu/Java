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
			//��������û���Ϊÿ���û����������ɫ
			User user1 = new User();
			User user2 = new User();
			user1.setUsername("name1");
			user1.setPassword("����1");
			user2.setUsername("name2");
			user2.setPassword("����2");
			Role role1 = new Role();
			Role role2 = new Role();
			Role role3 = new Role();
			role1.setRname("role1");
			role1.setRdesc("����1");
			role2.setRname("role2");
			role2.setRdesc("����2");
			role3.setRname("role3");
			role3.setRdesc("����3");
			
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
			session.delete(user);//ɾ��user��ͬʱ�Ὣuser1����Ӧ������role��ɾ��(��ʹrole��ֻ������user1)
			
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
			
			//����id��ѯ�û��ͽ�ɫ
			User user = session.get(User.class, 2);
			Role role4 = session.get(Role.class, 4);
			//�ѽ�ɫ�ŵ��û���set��������
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
			
			//����id��ѯ�û��ͽ�ɫ
			User user = session.get(User.class, 2);
			Role role4 = session.get(Role.class, 4);
			//���û���set��������ѽ�ɫ�Ƴ�
			user.getRoleSet().remove(role4);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
