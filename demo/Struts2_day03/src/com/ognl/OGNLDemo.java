package com.ognl;

import org.junit.Test;

import com.bean.User;
import com.opensymphony.xwork2.inject.Context;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OGNLDemo {
	//1.OGNL���ö���ķ���
	@Test
	public void demo1() throws OgnlException {
		//1.1 ���Context����
		OgnlContext ognlContext = new OgnlContext();
		//1.2 ��ø�����
		Object root = ognlContext.getRoot();
		Object value = Ognl.getValue("'welcome'.length()", ognlContext, root);
		System.out.println(value);
	}
	//2.���ʶ���ľ�̬����
	@Test
	public void demo2() throws OgnlException {
		//2.1 ���Context����
		OgnlContext ognlContext = new OgnlContext();
		//2.2 ��ø�����
		Object root = ognlContext.getRoot();
		//2.3 ִ�б��ʽ:	@����@������
		Object value = Ognl.getValue("@java.lang.Math@random()", ognlContext, root);
		System.out.println(value);
	}
	//3.���Root�е����ݣ�����Ҫ��#
	@Test
	public void demo3() throws OgnlException {
		//3.1 ���Context����
		OgnlContext ognlContext = new OgnlContext();
		//3.2 �������߻�ȡ������Դ�Ķ���
		//User user = new User(username, password);
		User user = new User("admin", "123456");
		//3.3 ��user���뵽Root��
		ognlContext.setRoot(user);
		//3.4 ��ø�����
		Object root = ognlContext.getRoot();
		//3.5 ִ�б��ʽ:
		Object username = Ognl.getValue("username", ognlContext, root);
		Object password = Ognl.getValue("password", ognlContext, root);
		System.out.println(username+":"+password);
	}
	//4.���OgnlContext�����е����ݣ���Ҫ��#
	@Test
	public void demo4() throws OgnlException {
		//4.1 ���Context����
		OgnlContext ognlContext = new OgnlContext();
		//4.2 ��ø�����
		Object root = ognlContext.getRoot();
		//4.3 ��ognlContext�д�����
		ognlContext.put("name", "admin");
		//4.4 ִ�б��ʽ:
		Object name = Ognl.getValue("#name", ognlContext, root);
		System.out.println(name);
	}
}
