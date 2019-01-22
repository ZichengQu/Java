package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Dept;
import com.dao.DeptDao;
import com.util.DBUtil;

public class DeptDaoImpl implements DeptDao {

	@Override
	public List<Dept> selAllDept() throws Exception {
		List<Dept> list = new ArrayList<Dept>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from dept";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new Dept(rs.getInt(1),rs.getString(2),rs.getString(3)));
		}
		DBUtil.close(conn, ps, rs);
		return list;
	}

}
