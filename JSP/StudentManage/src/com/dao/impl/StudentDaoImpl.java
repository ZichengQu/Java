package com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.StudentDao;
import com.entity.Student;
import com.sun.org.apache.regexp.internal.recompile;
import com.util.DBUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> selAllStudents() throws Exception {
		List<Student> list = new ArrayList<Student>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from student";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(
					new Student(rs.getInt("id"), 
								rs.getString("name"),
								rs.getString("hobby"), 
								rs.getString("school"), 
								rs.getDate("insertDate")
								)
					);
		}
		DBUtil.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<Student> selStudentByPage(int pageIndex, int pageSize) throws Exception {
		List<Student> list = new ArrayList<Student>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from (select rownum rn,stu.* from student stu where rownum <=?) t where t.rn>=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pageIndex*pageSize);
		ps.setInt(2, (pageIndex-1)*pageSize+1);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(
					new Student(rs.getInt("id"), 
								rs.getString("name"),
								rs.getString("hobby"), 
								rs.getString("school"), 
								rs.getDate("insertDate")
								)
					);
		}
		DBUtil.close(conn, ps, rs);
		return list;
	}

	@Override
	public void addStudent(Student stu) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into student values(stu_seq.nextval,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stu.getName());
		ps.setString(2, stu.getHobby());
		ps.setString(3, stu.getSchool());
		ps.setDate(4, new Date(stu.getInsertDate().getTime()));
		ps.executeUpdate();
		DBUtil.close(conn, ps, null);
	}

	@Override
	public Student selStuById(int id) throws Exception {
		Student stu = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from student where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			stu = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("hobby"), rs.getString("school"), rs.getDate("insertDate"));
		}
		DBUtil.close(conn, ps, rs);
		return stu;
	}

}
