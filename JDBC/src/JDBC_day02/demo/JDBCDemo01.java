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
 * 使用PrepareStatement，实现模糊查询。
 */
public class JDBCDemo01 {
	@Test
	public void fuzzyQuery() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		try {
			//1.连接数据库
			conn = DBUtil.getConnection();

			//2.获取连接对象，输入用户名和密码
			Scanner scanner = new Scanner(System.in);
			System.out.print("请输入查询条件： ");
			String condition = scanner.next();		
			String sql = "select * from emp where ename like ?";
			
			/*
			 * 3.创建PrepareStatement预编译对象
			 * 调用Connection接口的方法prepareStatement，获取PrepareStatement接口的实现类。
			 * SQL语句中的参数全部采用问号占位符。
			 * 调用PrepareStatement对象setXXX()方法，给问号赋值。
			 */
			ps = conn.prepareStatement(sql);//会预编译sql
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
