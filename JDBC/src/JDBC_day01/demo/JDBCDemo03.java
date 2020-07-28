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
 * PreparedStatement:Statement的子接口。
 * 预编译（sql是否合符规范），是Statement接口的子接口，防止SQL攻击（不是主要性能），提高代码的可读性，可维护性，提高效率。
 */
public class JDBCDemo03 {
	@Test
	public void login() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.加载驱动类(注册驱动)
			Class.forName("oracle.jdbc.driver.OracleDriver");//会优先加载静态代码块中的内容，因为OracleDriver的静态代码块中有DriverManager.registerDriver(new OracleDriver());
			//DriverManager.registerDriver(new OracleDriver());//也可以单独用这行代替Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "zicheng";
			String pwd = "qqq";
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("连接成功！");

			//2.获取连接 对象，输入用户名和密码
			Scanner scanner = new Scanner(System.in);
			System.out.print("请输入用户名： ");
			String name = scanner.next();
			System.out.print("请输入密码： ");
			String password = scanner.next();// SQL注入：select * from users where username='张三'and password='123456'or'a'='a';截取(两个单引号之间)123456'or'a'='a
			// String sql = "select * from users where username='张三丰' and
			// password='123456' or 1=1";//SQL注入
			String sql = "select * from users where username=? and password=?";
			
			/*
			 * 3.创建PrepareStatement预编译对象
			 * 调用Connection接口的方法prepareStatement，获取PrepareStatement接口的实现类。
			 * SQL语句中的参数全部采用问号占位符。
			 * 调用PrepareStatement对象setXXX()方法，给问号赋值。
			 */
			ps = conn.prepareStatement(sql);//会预编译sql
			ps.setString(1, name);//1和2是占位参数，表示第几个问号。
			ps.setString(2, password);
			//4.调用方法，执行sql语句，获取结果集。
			rs = ps.executeQuery();//因为prepareStatement已经预编译过sql，所以statement.executeQuery()不需要传sql参数了。
			//5.遍历结果集
			if (rs.next()) {
				System.out.println("登陆成功！");
			} else {
				System.out.println("用户名或密码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {//6.释放资源
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
