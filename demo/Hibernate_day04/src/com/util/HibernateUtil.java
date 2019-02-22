package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;
	
	static {
		Configuration conf = new Configuration();//��һ��������hibernate�������ļ�
		conf.configure();//���Զ�ȥsrc��Ѱ���������ļ�����������Ӧ��Ϣ��
		sf = conf.buildSessionFactory();//�ڶ���������sessionFactory����
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;//������Ŀ��Session����
	}
	
	public static Session getCurrentSession() {
		return sf.getCurrentSession();//�ṩ���������뵱ǰ�̰߳󶨵� Session
	}

}
