package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.entity.Student;
import com.service.StudentService;

public class StudentServiceImpl implements StudentService {
	StudentDao sDao = new StudentDaoImpl();
	@Override
	public List<Student> selAllStudents() {
		List<Student> list = null;
		try {
			list = sDao.selAllStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Student> selStudentByPage(int pageIndex, int pageSize) {
		List<Student> list = null;
		try {
			list = sDao.selStudentByPage(pageIndex, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void addStudent(Student stu) {
		try {
			sDao.addStudent(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public Student selStuById(int id) {
		Student stu = null;
		try {
			stu = sDao.selStuById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stu;
	}

}
