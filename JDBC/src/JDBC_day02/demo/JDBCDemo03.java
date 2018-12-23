package JDBC_day02.demo;

import java.sql.*;

import org.junit.Test;

import JDBC_day02.demo.util.DBUtil;

/*
 * 银行转账
 */
public class JDBCDemo03 {
	@Test
	public void account(){
		Connection conn = null;
		Statement s = null;
		try{
			conn = DBUtil.getConnection();
			s = conn.createStatement();
			
			String sql1 = "update t_account set balance=balance+20000 where id=1";
			String sql2 = "update t_account set balance=balance-20000 where id=2";	
			
			conn.setAutoCommit(false);//将事务的自动提交取消。
			s.executeUpdate(sql1);
			s.executeUpdate(sql2);			
			conn.commit();//手动提交事务，可将上面的逻辑全部控制在一个事务中。
			
			System.out.println("转账成功!");
		}catch(Exception e){
			try {
				System.out.println("出错了!");
				conn.rollback();//回滚事务。
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, s, null);
		}
	}
}
