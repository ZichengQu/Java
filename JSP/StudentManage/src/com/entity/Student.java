package com.entity;

import java.util.Date;

public class Student {
	private int id;
	private String name;
	private String hobby;
	private String school;
	private Date insertDate;
	
	public Student() {}
	
	public Student(int id, String name, String hobby, String school,
			Date insertDate) {
		this.id = id;
		this.name = name;
		this.hobby = hobby;
		this.school = school;
		this.insertDate = insertDate;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", hobby=" + hobby
				+ ", school=" + school + ", insertDate=" + insertDate + "]";
	}
	
	
}
