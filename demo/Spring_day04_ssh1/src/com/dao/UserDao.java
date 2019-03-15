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
		//hibernateTemplate对hibernate进行封装
		/*HibernateTemplate hibernateTemplate=new HibernateTemplate(sessionFactory);
		hibernateTemplate.save(entity);*/
		System.out.println("dao......");
		User user=new User();
		user.setName("马冬梅");
		user.setPassword("888");
		user.setEmail("mdm@qq.com");
		//使用save方法实现添加操作
		this.getHibernateTemplate().save(user);
	}
	//修改
	public void update(){
		User user=new User();
		user.setId(1);
		user.setName("大春");
		user.setPassword("888");
		this.getHibernateTemplate().update(user);
	}
	//删除
	public void delete(){
		User user=new User();
		user.setId(3);
		this.getHibernateTemplate().delete(user);
	}
	//根据id查询
	public User findById(){
		User user=this.getHibernateTemplate().load(User.class, 2);
		return user;
	}
	//查询全部
	public List<User> query(){
		//List<User> list=(List<User>) hibernateTemplate.find("from User where name=?","张三");
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("name", "张三"));
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
	//模糊查询
	public List<User> selUserByName(String name){
		//第一种方式
		/*SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where name like ?");
		query.setParameter(0, "%"+name+"%");
		List<User> list = query.list();*/
		//第二种方式
		/*List<User> list=(List<User>) this.getHibernateTemplate().find("from "
				+ "User where name like ?", "%"+name+"%");*/
		//第三种方式
		//1.创建离线查询对象，设置对哪个实体类进行操作
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		//2.设置对实体类哪个属性进行查询
		criteria.add(Restrictions.like("name", "%"+name+"%"));
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
		
		
	}
	//分页查询
	public List<User> selUserByPage(Integer pageIndex,Integer pageSize){
		//第一种 使用hibernate底层代码实现
		/*SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		//设置分页信息
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		List<User> list = query.list();*/
		//第二种方式
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria, 
				(pageIndex-1)*pageSize, pageSize);
		return list;
	}
	
	
	
	
}
