package com.bean;

public class User {
	private String username;
	public User(){}
	public User(String username) {
		this.username = username;
	}
	public void add(){
		System.out.println("add方法执行了......");
	}
	public static void main(String[] args) {
		//传统方式调用(耦合度高)
		/*User user=new User();
		user.add();*/
	}
}
