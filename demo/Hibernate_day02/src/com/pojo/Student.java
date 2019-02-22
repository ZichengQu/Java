package com.pojo;

public class Student {
	//hibernate要求实体类有一个属性是唯一的
	private int sid;
	private String sname;
	private String project;
	private double score;
	//底下是无参(必须)/有参构造和get，set方法
	public Student() {
		
	}
	
	public Student(int sid, String sname, String project, double score) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.project = project;
		this.score = score;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", project=" + project + ", score=" + score + "]";
	}
	
	
	
}
