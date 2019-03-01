package com.action;

import com.bean.Book;
import com.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class DataAction extends ActionSupport {
	//1.表达式封装，表达式封装可以归类到属性封装里面。
	//1.1声明实体类
	private User user;
	private Book book;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	//1.2.生成实体类变量的set和get方法；因为拦截器完成数据封装，需要创建User对象，通过get方法可以获得同一个对象，将数据封装set到同一个对象中。
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//1.3.在表单输入项的name属性值里面写表达式
	//1.4.使用user
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		System.out.println(book);
		return NONE;
	}	
}
