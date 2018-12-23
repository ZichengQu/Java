package JDBC_day01.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

/**
 * ʹ��PrepareStatement��ʵ�����ݱ�ĸ��²�����
 */
public class JDBCDemo04 {
	@Test
	public void login() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.����������(ע������)
			Class.forName("oracle.jdbc.driver.OracleDriver");//�����ȼ��ؾ�̬������е����ݣ���ΪOracleDriver�ľ�̬���������DriverManager.registerDriver(new OracleDriver());
			//DriverManager.registerDriver(new OracleDriver());//Ҳ���Ե��������д���Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "zicheng";
			String pwd = "qqq";
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("���ӳɹ���");

			//2.��ȡ���Ӷ��������û���������
			Scanner scanner = new Scanner(System.in);
			System.out.print("������Ҫ�޸ĵ��û���ţ� ");
			int id = scanner.nextInt();
			System.out.print("���������û����� ");
			String name = scanner.next();		
			String sql = "update users set username=? where id=?";
			
			/*
			 * 3.����PrepareStatementԤ�������
			 * ����Connection�ӿڵķ���prepareStatement����ȡPrepareStatement�ӿڵ�ʵ���ࡣ
			 * SQL����еĲ���ȫ�������ʺ�ռλ����
			 * ����PrepareStatement����setXXX()���������ʺŸ�ֵ��
			 */
			ps = conn.prepareStatement(sql);//��Ԥ����sql
			ps.setString(1, name);//1��2��ռλ��������ʾ�ڼ����ʺš�
			ps.setInt(2, id);
			
			int rows = ps.executeUpdate();//��ΪprepareStatement�Ѿ�Ԥ�����sql������statement.executeUpdate()����Ҫ��sql�����ˡ�
			System.out.println(rows);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
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
			
			
			
}
