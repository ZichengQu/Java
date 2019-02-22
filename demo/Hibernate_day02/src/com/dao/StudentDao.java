package com.dao;

import org.hibernate.Session;

import com.pojo.Student;
import com.util.HibernateUtil;

public class StudentDao {
	
	public void add(Student student) {
		Session session = HibernateUtil.getCurrentSession();
		session.save(student);
	}
}
