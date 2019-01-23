package com.dao;

import java.util.List;

import com.entity.Student;

public interface StudentDao {
	public List<Student> selAllStudents() throws Exception; 
	public List<Student> selStudentByPage(int pageIndex, int pageSize) throws Exception;
}
