package com.bean;

public class User {
	private String username;
	public User(){}
	public User(String username) {
		this.username = username;
	}
	public void add(){
		System.out.println("add����ִ����......");
	}
	public static void main(String[] args) {
		//��ͳ��ʽ����(��϶ȸ�)
		/*User user=new User();
		user.add();*/
	}
}
