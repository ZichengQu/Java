package com.action;

import com.bean.Book;
import com.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class DataAction extends ActionSupport {
	//1.���ʽ��װ�����ʽ��װ���Թ��ൽ���Է�װ���档
	//1.1����ʵ����
	private User user;
	private Book book;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	//1.2.����ʵ���������set��get��������Ϊ������������ݷ�װ����Ҫ����User����ͨ��get�������Ի��ͬһ�����󣬽����ݷ�װset��ͬһ�������С�
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//1.3.�ڱ��������name����ֵ����д���ʽ
	//1.4.ʹ��user
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		System.out.println(book);
		return NONE;
	}	
}
