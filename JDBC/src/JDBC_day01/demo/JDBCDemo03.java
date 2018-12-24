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
 * PreparedStatement:Statement���ӽӿڡ�
 * Ԥ���루sql�Ƿ�Ϸ��淶������Statement�ӿڵ��ӽӿڣ���ֹSQL������������Ҫ���ܣ�����ߴ���Ŀɶ��ԣ���ά���ԣ����Ч�ʡ�
 */
public class JDBCDemo03 {
	@Test
	public void login() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.����������(ע������)
			Class.forName("oracle.jdbc.driver.OracleDriver");//�����ȼ��ؾ�̬������е����ݣ���ΪOracleDriver�ľ�̬���������DriverManager.registerDriver(new OracleDriver());
			//DriverManager.registerDriver(new OracleDriver());//Ҳ���Ե��������д���Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "zicheng";
			String pwd = "qqq";
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("���ӳɹ���");

			//2.��ȡ���� ���������û���������
			Scanner scanner = new Scanner(System.in);
			System.out.print("�������û����� ");
			String name = scanner.next();
			System.out.print("���������룺 ");
			String password = scanner.next();// SQLע�룺select * from users where username='����'and password='123456'or'a'='a';��ȡ(����������֮��)123456'or'a'='a
			// String sql = "select * from users where username='������' and
			// password='123456' or 1=1";//SQLע��
			String sql = "select * from users where username=? and password=?";
			
			/*
			 * 3.����PrepareStatementԤ�������
			 * ����Connection�ӿڵķ���prepareStatement����ȡPrepareStatement�ӿڵ�ʵ���ࡣ
			 * SQL����еĲ���ȫ�������ʺ�ռλ����
			 * ����PrepareStatement����setXXX()���������ʺŸ�ֵ��
			 */
			ps = conn.prepareStatement(sql);//��Ԥ����sql
			ps.setString(1, name);//1��2��ռλ��������ʾ�ڼ����ʺš�
			ps.setString(2, password);
			//4.���÷�����ִ��sql��䣬��ȡ�������
			rs = ps.executeQuery();//��ΪprepareStatement�Ѿ�Ԥ�����sql������statement.executeQuery()����Ҫ��sql�����ˡ�
			//5.���������
			if (rs.next()) {
				System.out.println("��½�ɹ���");
			} else {
				System.out.println("�û������������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {//6.�ͷ���Դ
			try {
				if (rs != null) {
					rs.close();
				}
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
