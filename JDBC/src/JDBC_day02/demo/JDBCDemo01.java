package JDBC_day02.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import JDBC_day02.demo.util.DBUtil;

/**
 * ʹ��PrepareStatement��ʵ��ģ����ѯ��
 */
public class JDBCDemo01 {
	@Test
	public void fuzzyQuery() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		try {
			//1.�������ݿ�
			conn = DBUtil.getConnection();

			//2.��ȡ���Ӷ��������û���������
			Scanner scanner = new Scanner(System.in);
			System.out.print("�������ѯ������ ");
			String condition = scanner.next();		
			String sql = "select * from emp where ename like ?";
			
			/*
			 * 3.����PrepareStatementԤ�������
			 * ����Connection�ӿڵķ���prepareStatement����ȡPrepareStatement�ӿڵ�ʵ���ࡣ
			 * SQL����еĲ���ȫ�������ʺ�ռλ����
			 * ����PrepareStatement����setXXX()���������ʺŸ�ֵ��
			 */
			ps = conn.prepareStatement(sql);//��Ԥ����sql
			ps.setString(1, "%"+condition+"%");
			
			rs = ps.executeQuery();
			while(rs.next()){
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				System.out.println(empno+"\t"+ename+"\t"+job);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}

	}
			
			
			
}
