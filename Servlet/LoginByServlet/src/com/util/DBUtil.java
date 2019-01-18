package com.util;

import java.sql.*;

/*
 * 实现JDBC的工具类
 * 定义方法，直接返回数据库的连接对象
 * 关闭所有资源
 */
public class DBUtil {
	//链接数据库的封装方法
	public static Connection getConnection(){
		Connection conn = null;
		try {
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "zicheng";
			String password = "qqq";
			//获取连接对象
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("使用DBUtil连接Oracle成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//增加、删除、修改
	public static int executeUpdate(String sql,Object[] obj){
		Connection conn = null;
		PreparedStatement ps = null;
		int rows = 0;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				ps.setObject(i+1, obj[i]);
			}
			rows = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, null);
		}
		return rows;
	}
	
	//关闭所有内容
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DBUtil.getConnection();
	}
}
