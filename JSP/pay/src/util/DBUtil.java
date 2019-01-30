package util;

import java.sql.*;
public class DBUtil {
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "zicheng";
			String password = "qqq";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("使用DBUtil连接Oracle成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn, Statement statement, ResultSet rs){//Statement
		try {
			if(rs != null){
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
