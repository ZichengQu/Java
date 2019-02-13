package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.AdminDao;
import entity.Admin;
import util.DBUtil;

public class AdminDaoImpl implements AdminDao {
	@Override
	public Admin selectAdminByCode(String admin_code) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from admin_info where admin_code=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, admin_code);
		ResultSet rs = ps.executeQuery();
		Admin admin = null;
		if(rs.next()) {
			admin = new Admin(
					rs.getInt("admin_id"), 
					rs.getString("admin_code"), 
					rs.getString("password"), 
					rs.getString("name"), 
					rs.getString("telephone"), 
					rs.getString("email"), 
					rs.getTimestamp("enrolldate")
					);
		}
		DBUtil.close(conn, ps, rs);
		return admin;
	}

}
