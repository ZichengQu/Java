package JDBC_day01.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

/**
 * Java����ʵ���û���¼����֤�û��������롣 
 * ��ʾSQLע�빥����
 */
public class JDBCDemo02 {

	@Test
	public void login() {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			//1.�������ݿ�
			Class.forName("oracle.jdbc.driver.OracleDriver");// �����ȼ��ؾ�̬������е����ݣ���ΪOracleDriver�ľ�̬���������DriverManager.registerDriver(new OracleDriver());
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "zicheng";
			String pwd = "qqq";
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("���ӳɹ���");

			//2.�����û��������뼰sql���ƴ��
			Scanner scanner = new Scanner(System.in);
			System.out.print("�������û����� ");
			String name = scanner.next();
			System.out.print("���������룺 ");
			String password = scanner.next();// SQLע�룺select * from users where username='����'and password='123456'or'a'='a';��ȡ(����������֮��)123456'or'a'='a
			// String sql = "select * from users where username='������' and
			// password='123456' or 1=1";//SQLע��
			String sql = "select * from users where username='" + name + "'and password='" + password + "'";
			System.out.println(sql);
			
			//3.ͨ��Connection���󴴽�Statement����
			statement = conn.createStatement();
			//4.ִ��sql��䣨�����ǲ�ѯ��
			rs = statement.executeQuery(sql);
			//5.��ȡ�����������next()���������ж��û��Ƿ��½�ɹ���
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
}
