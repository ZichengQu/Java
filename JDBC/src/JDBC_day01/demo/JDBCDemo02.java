package JDBC_day01.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

/**
 * Java程序实现用户登录，验证用户名和密码。 
 * 演示SQL注入攻击。
 */
public class JDBCDemo02 {

	@Test
	public void login() {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			//1.连接数据库
			Class.forName("oracle.jdbc.driver.OracleDriver");// 会优先加载静态代码块中的内容，因为OracleDriver的静态代码块中有DriverManager.registerDriver(new OracleDriver());
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "zicheng";
			String pwd = "qqq";
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("连接成功！");

			//2.输入用户名和密码及sql语句拼接
			Scanner scanner = new Scanner(System.in);
			System.out.print("请输入用户名： ");
			String name = scanner.next();
			System.out.print("请输入密码： ");
			String password = scanner.next();// SQL注入：select * from users where username='张三'and password='123456'or'a'='a';截取(两个单引号之间)123456'or'a'='a
			// String sql = "select * from users where username='张三丰' and
			// password='123456' or 1=1";//SQL注入
			String sql = "select * from users where username='" + name + "'and password='" + password + "'";
			System.out.println(sql);
			
			//3.通过Connection对象创建Statement对象
			statement = conn.createStatement();
			//4.执行sql语句（例子是查询）
			rs = statement.executeQuery(sql);
			//5.获取结果集，并用next()进行数据判断用户是否登陆成功。
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
