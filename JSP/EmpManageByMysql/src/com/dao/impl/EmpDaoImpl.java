package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Emp;
import com.bean.PageBean;
import com.dao.EmpDao;
import com.util.DBUtil;

public class EmpDaoImpl implements EmpDao {
	@Override
	public List<Emp> selAllEmp() throws Exception {
		List<Emp> list = new ArrayList<Emp>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from emp";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int eno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			int mgr = rs.getInt("mgr");
			Date hiredate = rs.getDate("hiredate");
			double sal = rs.getDouble("sal");
			double comm = rs.getDouble("comm");
			int deptno = rs.getInt("deptno");
			Emp emp = new Emp(eno, ename, job, mgr, hiredate, sal, comm, deptno);
			list.add(emp);
		}
		DBUtil.close(conn, ps, rs);
		return list;
	}
	
	@Override
	public List<Emp> selEmpByPage(PageBean pBean) throws Exception {
		List<Emp> list = new ArrayList<Emp>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from emp limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pBean.getPageIndex()-1)*pBean.getPageSize());
		ps.setInt(2, pBean.getPageSize());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int eno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			int mgr = rs.getInt("mgr");
			Date hiredate = rs.getDate("hiredate");
			double sal = rs.getDouble("sal");
			double comm = rs.getDouble("comm");
			int deptno = rs.getInt("deptno");
			Emp emp = new Emp(eno, ename, job, mgr, hiredate, sal, comm, deptno);
			list.add(emp);
		}
		DBUtil.close(conn, ps, rs);
		return list;
	}

	

}
