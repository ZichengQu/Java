package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;
	static {
		//��һ��������hibernate�������ļ�
		Configuration conf = new Configuration();
		conf.configure();//���Զ�ȥsrc��Ѱ���������ļ�����������Ӧ��Ϣ��
		//�ڶ���������sessionFactory����
		sf = conf.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
