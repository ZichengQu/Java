package JDBC_day02.demo;

import java.sql.*;
import java.util.*;
import org.junit.Test;

import JDBC_day02.demo.bean.Users;
import JDBC_day02.demo.util.DBUtil;

/**
 * JDBC��ȡ���ݱ�users��ÿ�����ݷ�װ��USers��Ķ����С�
 */
public class JDBCDemo02 {
	@Test
	public void fuzzyQuery() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();

			String sql = "select * from users";

			ps = conn.prepareStatement(sql);//��Ԥ����sql
			
			rs = ps.executeQuery();
			
			List<Users> list = new ArrayList<Users>();//�������϶���
			
			while(rs.next()){//��ȡ�������ÿ�е����ݣ���װ��Users������
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Users user = new Users(id,username,password);
				list.add(user);
			}
			for(Users user: list){
				System.out.println(user.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}

	}
			
			
			
}
