package com.service;

import java.util.List;

import com.entity.Student;

public interface StudentService {
	public List<Student> selAllStudents();
	public List<Student> selStudentByPage(int pageIndex, int pageSize);
	public void addStudent(Student stu);
	public Student selStuById(int id);
}
