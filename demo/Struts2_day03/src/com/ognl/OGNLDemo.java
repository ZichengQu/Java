package com.ognl;

import org.junit.Test;

import com.bean.User;
import com.opensymphony.xwork2.inject.Context;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OGNLDemo {
	//1.OGNL调用对象的方法
	@Test
	public void demo1() throws OgnlException {
		//1.1 获得Context对象
		OgnlContext ognlContext = new OgnlContext();
		//1.2 获得根对象
		Object root = ognlContext.getRoot();
		Object value = Ognl.getValue("'welcome'.length()", ognlContext, root);
		System.out.println(value);
	}
	//2.访问对象的静态方法
	@Test
	public void demo2() throws OgnlException {
		//2.1 获得Context对象
		OgnlContext ognlContext = new OgnlContext();
		//2.2 获得根对象
		Object root = ognlContext.getRoot();
		//2.3 执行表达式:	@类名@方法名
		Object value = Ognl.getValue("@java.lang.Math@random()", ognlContext, root);
		System.out.println(value);
	}
	//3.获得Root中的数据，不需要加#
	@Test
	public void demo3() throws OgnlException {
		//3.1 获得Context对象
		OgnlContext ognlContext = new OgnlContext();
		//3.2 创建或者获取其它来源的对象
		//User user = new User(username, password);
		User user = new User("admin", "123456");
		//3.3 将user存入到Root中
		ognlContext.setRoot(user);
		//3.4 获得根对象
		Object root = ognlContext.getRoot();
		//3.5 执行表达式:
		Object username = Ognl.getValue("username", ognlContext, root);
		Object password = Ognl.getValue("password", ognlContext, root);
		System.out.println(username+":"+password);
	}
	//4.获得OgnlContext对象中的数据，需要加#
	@Test
	public void demo4() throws OgnlException {
		//4.1 获得Context对象
		OgnlContext ognlContext = new OgnlContext();
		//4.2 获得根对象
		Object root = ognlContext.getRoot();
		//4.3 向ognlContext中存数据
		ognlContext.put("name", "admin");
		//4.4 执行表达式:
		Object name = Ognl.getValue("#name", ognlContext, root);
		System.out.println(name);
	}
}
