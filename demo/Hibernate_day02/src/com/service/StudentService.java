package com.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.StudentDao;
import com.pojo.Student;
import com.util.HibernateUtil;

public class StudentService {
	private StudentDao studentDao = new StudentDao();
	
	public void add(Student student) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			studentDao.add(student);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
