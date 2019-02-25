package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.AdminDao;
import entity.Admin;
import util.HibernateUtil;

public class AdminDaoImpl implements AdminDao {
	@Override
	public Admin selectAdminByCode(String admin_code){
		Admin admin = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Admin where adminCode=?");
			query.setParameter(0, admin_code);
			List<Admin> list = query.list();
			if(list!=null&&!list.isEmpty()) {
				admin = list.get(0);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return admin;
	}

}
