package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;
	
	static {
		//第一步：加载hibernate主配置文件
		Configuration conf = new Configuration();
		conf.configure();//会自动去src下寻找主配置文件，并加载相应信息。
		//第二步：创建sessionFactory对象
		sf = conf.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
	
	public static Session getCurrentSession() {
		return sf.getCurrentSession();//提供方法返回与本地线程绑定的 Session
	}
}
