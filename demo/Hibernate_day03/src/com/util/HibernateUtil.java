package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;
	
	static {
		Configuration conf = new Configuration();//第一步：加载hibernate主配置文件
		conf.configure();//会自动去src下寻找主配置文件，并加载相应信息。
		sf = conf.buildSessionFactory();//第二步：创建sessionFactory对象
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;//返回项目的Session工厂
	}
	
	public static Session getCurrentSession() {
		return sf.getCurrentSession();//提供方法返回与当前线程绑定的 Session
	}

}
