package com.util;

import java.sql.*;

/*
 * ʵ��JDBC�Ĺ�����
 * ���巽����ֱ�ӷ������ݿ�����Ӷ���
 * �ر�������Դ
 */
public class DBUtil {
	//�������ݿ�ķ�װ����
	public static Connection getConnection(){
		Connection conn = null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/empdb";//ָ�����ӵ����ݿ�����Ϊempdb
			String user = "root";
			String password = "root";
			//��ȡ���Ӷ���
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("ʹ��DBUtil����Oracle�ɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//���ӡ�ɾ�����޸�
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
	
	//�ر���������
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
}
