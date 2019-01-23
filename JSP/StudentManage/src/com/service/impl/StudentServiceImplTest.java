package com.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.entity.Student;
import com.service.StudentService;

class StudentServiceImplTest {


	@Test
	void test() {
		StudentService sService = new StudentServiceImpl();
		List<Student> list = sService.selAllStudents();
		System.out.println(list);
	}

}
