package com.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.pojo.Student;
import com.util.HibernateUtil;

public class Demo {
	@Test
	public void testAdd() {
		/*
		//第一步：加载hibernate主配置文件
		Configuration conf = new Configuration();
		conf.configure();//会自动去src下寻找主配置文件，并加载相应信息。
		//第二步：创建sessionFactory对象
		SessionFactory sf = conf.buildSessionFactory();
		*/
		
		SessionFactory sf = HibernateUtil.getSessionFactory();//使用工具类获取静态SessionFactory对象。
		//第三步：使用sessionFactory创建session对象
		Session session = sf.openSession();
		//第四步：开启事务
		Transaction transaction = session.beginTransaction();
		//第五步：具体的逻辑(增删改查操作)
		Student student = new Student();
		student.setSname("学生的名字");
		student.setProject("mysql的项目");
		student.setScore(100);
		Serializable id = session.save(student);//它返回的是存储对象时生成的主键
		System.out.println(id);
		//第六步：提交事务
		transaction.commit();
		//第七步：关闭资源
		session.close();
		//sf.close();//web项目的时候，不需要关闭SessionFactory对象，因为是多个共享同一个SessionFactory。
	}
}
