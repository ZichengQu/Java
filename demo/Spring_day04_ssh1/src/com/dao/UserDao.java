package com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.bean.User;

public class UserDao extends HibernateDaoSupport{
	public void add(){
		//hibernateTemplate��hibernate���з�װ
		/*HibernateTemplate hibernateTemplate=new HibernateTemplate(sessionFactory);
		hibernateTemplate.save(entity);*/
		System.out.println("dao......");
		User user=new User();
		user.setName("��÷");
		user.setPassword("888");
		user.setEmail("mdm@qq.com");
		//ʹ��save����ʵ����Ӳ���
		this.getHibernateTemplate().save(user);
	}
	//�޸�
	public void update(){
		User user=new User();
		user.setId(1);
		user.setName("��");
		user.setPassword("888");
		this.getHibernateTemplate().update(user);
	}
	//ɾ��
	public void delete(){
		User user=new User();
		user.setId(3);
		this.getHibernateTemplate().delete(user);
	}
	//����id��ѯ
	public User findById(){
		User user=this.getHibernateTemplate().load(User.class, 2);
		return user;
	}
	//��ѯȫ��
	public List<User> query(){
		//List<User> list=(List<User>) hibernateTemplate.find("from User where name=?","����");
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("name", "����"));
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
	//ģ����ѯ
	public List<User> selUserByName(String name){
		//��һ�ַ�ʽ
		/*SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where name like ?");
		query.setParameter(0, "%"+name+"%");
		List<User> list = query.list();*/
		//�ڶ��ַ�ʽ
		/*List<User> list=(List<User>) this.getHibernateTemplate().find("from "
				+ "User where name like ?", "%"+name+"%");*/
		//�����ַ�ʽ
		//1.�������߲�ѯ�������ö��ĸ�ʵ������в���
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		//2.���ö�ʵ�����ĸ����Խ��в�ѯ
		criteria.add(Restrictions.like("name", "%"+name+"%"));
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
		
		
	}
	//��ҳ��ѯ
	public List<User> selUserByPage(Integer pageIndex,Integer pageSize){
		//��һ�� ʹ��hibernate�ײ����ʵ��
		/*SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		//���÷�ҳ��Ϣ
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		List<User> list = query.list();*/
		//�ڶ��ַ�ʽ
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria, 
				(pageIndex-1)*pageSize, pageSize);
		return list;
	}
	
	
	
	
}
