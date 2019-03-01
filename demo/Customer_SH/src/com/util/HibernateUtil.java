package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;
	static{
		Configuration conf=new Configuration();
		conf.configure();
		sf=conf.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return sf;
	}
	public static Session getCurrentSession(){
		return sf.getCurrentSession();
	}
}
