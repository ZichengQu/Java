package JDBC_day01.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import oracle.jdbc.driver.OracleDriver;

/**
 * 1.什么是JDBC？
 * JDBC(Java DataBase Connection)是一种用于执行SQL语句的Java的API，可以为多种关系型数据库提供统一访问，它由一组用Java语言编写的类和接口组成，是Java访问数据库的标准规范。
 * 2.JDBC入门：
 * 	(1)导入jar包：连接数据库的驱动。
 * 	(2)加载驱动类:Class.forName("类名");
 *  (3)创建连接：DriverManager(驱动管理器)，提供一个静态方法，建立与数据库的连接,getConnection(url(连接数据库地址),username,password)
 */
public class JDBCDemo01 {
	/**
	 * JDBC所需四个参数：
	 * 1.driverClassName:oracle.jdbc.driver.OracleDriver
	 * 2.url:连接数据库地址,jdbc:oracle:thin:@localhost:1521:orcl
	 * 3.username: zicheng
	 * 4.password: qqq
	 */
	@Test
	public void fun() throws ClassNotFoundException, SQLException{
		//1.加载驱动类(注册驱动)
		Class.forName("oracle.jdbc.driver.OracleDriver");//会优先加载静态代码块中的内容，因为OracleDriver的静态代码块中有DriverManager.registerDriver(new OracleDriver());
		//DriverManager.registerDriver(new OracleDriver());//也可以单独用这行代替Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="zicheng";
		String pwd="qqq";
		//2.创建连接对象
		Connection conn = DriverManager.getConnection(url, user, pwd);
		//System.out.println(conn);
		/* 
		 * 3.通过Connection对象创建Statement对象
		 * (1)通过COnnection对象创建的Statement，它的功能就是向数据库发送sql语句。
		 * (2)调用int executeUpdate(String sql)//对数据库进行增删改操作,执行给定的SQL语句，这可能是 INSERT ， UPDATE ，或 DELETE语句，或者不返回任何内容，如SQL DDL语句的SQL语句。
		 */
		Statement statement = conn.createStatement();
		//4.执行sql语句（DML）
		String sql="insert into emp(empno,ename,job)values(888,'Tony','boss')";//添加语句
		//int rows = statement.executeUpdate(sql);//影响了多少行
		String sql1="update emp set job='big boss' where empno=888";
		//int rows1 = statement.executeUpdate(sql1);
		String sql2 = "delete from emp where job='big boss'";
		//int rows2 = statement.executeUpdate(sql2);
		//5.释放资源
		statement.close();
		conn.close();//必须要关的，有连接数量上限，否则数据库会崩溃。
	}
	
	/**
	 * 查询
	 * 1.得到Connection
	 * 2.得到Statement对象，发送SQL语句
	 * 3.对查询返回的结果集进行解析
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	@Test
	public void query() throws ClassNotFoundException, SQLException{
		//1.加载驱动类(注册驱动)
		Class.forName("oracle.jdbc.driver.OracleDriver");//会优先加载静态代码块中的内容，因为OracleDriver的静态代码块中有DriverManager.registerDriver(new OracleDriver());
		//DriverManager.registerDriver(new OracleDriver());//也可以单独用这行代替Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="zicheng";
		String pwd="qqq";
		//2.创建连接对象
		Connection conn = DriverManager.getConnection(url, user, pwd);
		//3.通过Connection对象创建Statement对象
		Statement statement = conn.createStatement();
		/* 
		 * 4.执行sql语句
		 * ResultSet executeQuery(String sql)//执行给定的SQL语句，该语句返回单个 ResultSet对象。
		 */
		String sql ="select * from emp";		
		ResultSet rs = statement.executeQuery(sql);
		/*
		 * 5.解析ResultSet
		 * 可以调用ResultSet的boolean next()把行光标移动到第下一行.
		 * 在ResultSet结果集中有一个行光标（只能上下移动，不能左右移动），对表中所有数据进行遍历。起始行位于第一行之前，终止行位于最后一行之后。
		 * ResultSet提供一系列的getXXX()方法，getInt(),getString(),getDouble(),getDate(),getObject().
		 * getInt(1),getInt(empno);//获取第一列，或直接写列名。
		 */
		while(rs.next()){//将光标向下移动一行并判断是否存在。若存在则返回true，否则返回false。
			int empno = rs.getInt(1);//通过列编号来获取该列的值
			String ename = rs.getString("ename");//通过列名来获取该列的值。
			double sal = rs.getDouble("sal");
			String job = rs.getString("job");
			System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+job);
		}
		//6.释放资源
		rs.close();
		statement.close();
		conn.close();//必须要关的，有连接数量上限，否则数据库会崩溃。
	}

	/**
	 * 规范写法
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//会优先加载静态代码块中的内容，因为OracleDriver的静态代码块中有DriverManager.registerDriver(new OracleDriver());
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="zicheng";
			String pwd="qqq";
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("连接成功！");
			String sql = "select * from emp where ename like '%A%'";
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()){//将光标向下移动一行并判断是否存在。若存在则返回true，否则返回false。
				int empno = rs.getInt(1);//通过列编号来获取该列的值
				String ename = rs.getString("ename");//通过列名来获取该列的值。
				double sal = rs.getDouble("sal");
				String job = rs.getString("job");
				System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+job);
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{			
			try {
				if(rs!=null){
					rs.close();
				}
				if(statement!=null){
					statement.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


