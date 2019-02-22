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
		//��һ��������hibernate�������ļ�
		Configuration conf = new Configuration();
		conf.configure();//���Զ�ȥsrc��Ѱ���������ļ�����������Ӧ��Ϣ��
		//�ڶ���������sessionFactory����
		SessionFactory sf = conf.buildSessionFactory();
		*/
		
		SessionFactory sf = HibernateUtil.getSessionFactory();//ʹ�ù������ȡ��̬SessionFactory����
		//��������ʹ��sessionFactory����session����
		Session session = sf.openSession();
		//���Ĳ�����������
		Transaction transaction = session.beginTransaction();
		//���岽��������߼�(��ɾ�Ĳ����)
		Student student = new Student();
		student.setSname("ѧ��������");
		student.setProject("mysql����Ŀ");
		student.setScore(100);
		Serializable id = session.save(student);//�����ص��Ǵ洢����ʱ���ɵ�����
		System.out.println(id);
		//���������ύ����
		transaction.commit();
		//���߲����ر���Դ
		session.close();
		//sf.close();//web��Ŀ��ʱ�򣬲���Ҫ�ر�SessionFactory������Ϊ�Ƕ������ͬһ��SessionFactory��
	}
}
