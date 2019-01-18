package com.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bean.User;
import com.dao.UserDao;
import com.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User login(String username, String password) throws Exception {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//1.创建连接对象
		conn = DBUtil.getConnection();
		String sql = "select * from users where username=? and password=?";
		//2.创建预编译对象
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		rs = ps.executeQuery();
		//4.遍历结果集
		while(rs.next()) {
			user = new User(
					rs.getInt("id"),rs.getString("username"),rs.getString("password")
					);
		}
		//5.关流
		DBUtil.close(conn, ps, rs);
		return user;
	}

	@Override
	public List<User> queryAll() throws Exception {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = DBUtil.getConnection();
		String sql = "select * from users";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new User(rs.getInt("id"),rs.getString("username"),rs.getString("password")));
		}
		DBUtil.close(conn, ps, rs);
		return list;
	}
	
}
