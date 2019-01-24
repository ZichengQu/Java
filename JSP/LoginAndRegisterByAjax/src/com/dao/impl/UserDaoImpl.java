package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Users;
import com.dao.UserDao;
import com.sun.crypto.provider.RSACipher;
import com.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public Users selUserByName(String name) throws Exception {
		Users user = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from users where username=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new Users(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
		}
		DBUtil.close(conn, ps, rs);
		return user;
	}

	

}
