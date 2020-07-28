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
 * 使用PrepareStatement，实现数据表的更新操作。
 */
public class JDBCDemo04 {
	@Test
	public void login() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.加载驱动类(注册驱动)
			Class.forName("oracle.jdbc.driver.OracleDriver");//会优先加载静态代码块中的内容，因为OracleDriver的静态代码块中有DriverManager.registerDriver(new OracleDriver());
			//DriverManager.registerDriver(new OracleDriver());//也可以单独用这行代替Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "zicheng";
			String pwd = "qqq";
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("连接成功！");

			//2.获取连接对象，输入用户名和密码
			Scanner scanner = new Scanner(System.in);
			System.out.print("请输入要修改的用户编号： ");
			int id = scanner.nextInt();
			System.out.print("请输入新用户名： ");
			String name = scanner.next();		
			String sql = "update users set username=? where id=?";
			
			/*
			 * 3.创建PrepareStatement预编译对象
			 * 调用Connection接口的方法prepareStatement，获取PrepareStatement接口的实现类。
			 * SQL语句中的参数全部采用问号占位符。
			 * 调用PrepareStatement对象setXXX()方法，给问号赋值。
			 */
			ps = conn.prepareStatement(sql);//会预编译sql
			ps.setString(1, name);//1和2是占位参数，表示第几个问号。
			ps.setInt(2, id);
			
			int rows = ps.executeUpdate();//因为prepareStatement已经预编译过sql，所以statement.executeUpdate()不需要传sql参数了。
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
