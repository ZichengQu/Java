package JDBC_day02.demo;

import java.sql.*;

import org.junit.Test;

import JDBC_day02.demo.util.DBUtil;

/*
 * ����ת��
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
			
			conn.setAutoCommit(false);//��������Զ��ύȡ����
			s.executeUpdate(sql1);
			s.executeUpdate(sql2);			
			conn.commit();//�ֶ��ύ���񣬿ɽ�������߼�ȫ��������һ�������С�
			
			System.out.println("ת�˳ɹ�!");
		}catch(Exception e){
			try {
				System.out.println("������!");
				conn.rollback();//�ع�����
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, s, null);
		}
	}
}
