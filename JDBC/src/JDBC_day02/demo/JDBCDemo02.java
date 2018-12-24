package JDBC_day02.demo;

import java.sql.*;
import java.util.*;
import org.junit.Test;

import JDBC_day02.demo.bean.Users;
import JDBC_day02.demo.util.DBUtil;

/**
 * JDBC读取数据表users，每行数据封装到USers类的对象中。
 */
public class JDBCDemo02 {
	@Test
	public void fuzzyQuery() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();

			String sql = "select * from users";

			ps = conn.prepareStatement(sql);//会预编译sql
			
			rs = ps.executeQuery();
			
			List<Users> list = new ArrayList<Users>();//创建集合对象
			
			while(rs.next()){//获取结果集中每行的数据，封装到Users对象中
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Users user = new Users(id,username,password);
				list.add(user);
			}
			for(Users user: list){
				System.out.println(user.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}

	}
			
			
			
}
