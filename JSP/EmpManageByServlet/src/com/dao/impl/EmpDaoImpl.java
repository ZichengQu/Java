package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Dept;
import com.bean.Emp;
import com.dao.EmpDao;
import com.util.DBUtil;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> selAllEmp() throws Exception {
		List<Emp> list = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = DBUtil.getConnection();
		String sql = "select * from emp";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getDouble(6),rs.getDouble(7),rs.getInt(8)));
		}
		
		DBUtil.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<Emp> queryEmpByEname(String ename) throws Exception {
		List<Emp> list = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = DBUtil.getConnection();
		String sql = "select * from emp where ename like ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "%"+ename+"%");
		rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getDouble(6),rs.getDouble(7),rs.getInt(8)));
		}
		
		DBUtil.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<Emp> selEmpByCondition(String condition, String value) throws Exception {
		List<Emp> list = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		
		conn = DBUtil.getConnection();
		if("ename".equals(condition)) {
			sql = "select * from emp where ename like ?";
		}else {
			sql = "select * from emp where job like ?";
		}
		ps = conn.prepareStatement(sql);
		ps.setString(1, "%"+value+"%");
		rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getDouble(6),rs.getDouble(7),rs.getInt(8)));
		}
		
		DBUtil.close(conn, ps, rs);
		return list;
	}

	@Override
	public int delEmpById(int empno) throws Exception {
		int num = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = DBUtil.getConnection();
		String sql = "delete from emp where empno = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, empno);
		num = ps.executeUpdate();
		
		DBUtil.close(conn, ps, null);
		return num;
	}
	@Override
	public int addEmp(Emp emp) throws Exception {
		int num = 0;
		Connection conn = DBUtil.getConnection();
		String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, emp.getEmpno());
		ps.setString(2, emp.getEname());
		ps.setString(3, emp.getJob());
		ps.setInt(4, emp.getMgr());
		ps.setDate(5, new java.sql.Date(emp.getHiredate().getTime()));
		ps.setDouble(6, emp.getSal());
		ps.setDouble(7, emp.getComm());
		ps.setInt(8, emp.getDeptno());
		num = ps.executeUpdate();
		
		DBUtil.close(conn, ps, null);
		return num;
	}
}
