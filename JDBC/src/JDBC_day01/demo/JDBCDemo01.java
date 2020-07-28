package JDBC_day01.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import oracle.jdbc.driver.OracleDriver;

/**
 * 1.ʲô��JDBC��
 * JDBC(Java DataBase Connection)��һ������ִ��SQL����Java��API������Ϊ���ֹ�ϵ�����ݿ��ṩͳһ���ʣ�����һ����Java���Ա�д����ͽӿ���ɣ���Java�������ݿ�ı�׼�淶��
 * 2.JDBC���ţ�
 * 	(1)����jar�����������ݿ��������
 * 	(2)����������:Class.forName("����");
 *  (3)�������ӣ�DriverManager(����������)���ṩһ����̬���������������ݿ������,getConnection(url(�������ݿ��ַ),username,password)
 */
public class JDBCDemo01 {
	/**
	 * JDBC�����ĸ�������
	 * 1.driverClassName:oracle.jdbc.driver.OracleDriver
	 * 2.url:�������ݿ��ַ,jdbc:oracle:thin:@localhost:1521:orcl
	 * 3.username: zicheng
	 * 4.password: qqq
	 */
	@Test
	public void fun() throws ClassNotFoundException, SQLException{
		//1.����������(ע������)
		Class.forName("oracle.jdbc.driver.OracleDriver");//�����ȼ��ؾ�̬������е����ݣ���ΪOracleDriver�ľ�̬���������DriverManager.registerDriver(new OracleDriver());
		//DriverManager.registerDriver(new OracleDriver());//Ҳ���Ե��������д���Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="zicheng";
		String pwd="qqq";
		//2.�������Ӷ���
		Connection conn = DriverManager.getConnection(url, user, pwd);
		//System.out.println(conn);
		/* 
		 * 3.ͨ��Connection���󴴽�Statement����
		 * (1)ͨ��COnnection���󴴽���Statement�����Ĺ��ܾ��������ݿⷢ��sql��䡣
		 * (2)����int executeUpdate(String sql)//�����ݿ������ɾ�Ĳ���,ִ�и�����SQL��䣬������� INSERT �� UPDATE ���� DELETE��䣬���߲������κ����ݣ���SQL DDL����SQL��䡣
		 */
		Statement statement = conn.createStatement();
		//4.ִ��sql��䣨DML��
		String sql="insert into emp(empno,ename,job)values(888,'Tony','boss')";//������
		//int rows = statement.executeUpdate(sql);//Ӱ���˶�����
		String sql1="update emp set job='big boss' where empno=888";
		//int rows1 = statement.executeUpdate(sql1);
		String sql2 = "delete from emp where job='big boss'";
		//int rows2 = statement.executeUpdate(sql2);
		//5.�ͷ���Դ
		statement.close();
		conn.close();//����Ҫ�صģ��������������ޣ��������ݿ�������
	}
	
	/**
	 * ��ѯ
	 * 1.�õ�Connection
	 * 2.�õ�Statement���󣬷���SQL���
	 * 3.�Բ�ѯ���صĽ�������н���
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	@Test
	public void query() throws ClassNotFoundException, SQLException{
		//1.����������(ע������)
		Class.forName("oracle.jdbc.driver.OracleDriver");//�����ȼ��ؾ�̬������е����ݣ���ΪOracleDriver�ľ�̬���������DriverManager.registerDriver(new OracleDriver());
		//DriverManager.registerDriver(new OracleDriver());//Ҳ���Ե��������д���Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="zicheng";
		String pwd="qqq";
		//2.�������Ӷ���
		Connection conn = DriverManager.getConnection(url, user, pwd);
		//3.ͨ��Connection���󴴽�Statement����
		Statement statement = conn.createStatement();
		/* 
		 * 4.ִ��sql���
		 * ResultSet executeQuery(String sql)//ִ�и�����SQL��䣬����䷵�ص��� ResultSet����
		 */
		String sql ="select * from emp";		
		ResultSet rs = statement.executeQuery(sql);
		/*
		 * 5.����ResultSet
		 * ���Ե���ResultSet��boolean next()���й���ƶ�������һ��.
		 * ��ResultSet���������һ���й�ֻ꣨�������ƶ������������ƶ������Ա����������ݽ��б�������ʼ��λ�ڵ�һ��֮ǰ����ֹ��λ�����һ��֮��
		 * ResultSet�ṩһϵ�е�getXXX()������getInt(),getString(),getDouble(),getDate(),getObject().
		 * getInt(1),getInt(empno);//��ȡ��һ�У���ֱ��д������
		 */
		while(rs.next()){//����������ƶ�һ�в��ж��Ƿ���ڡ��������򷵻�true�����򷵻�false��
			int empno = rs.getInt(1);//ͨ���б������ȡ���е�ֵ
			String ename = rs.getString("ename");//ͨ����������ȡ���е�ֵ��
			double sal = rs.getDouble("sal");
			String job = rs.getString("job");
			System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+job);
		}
		//6.�ͷ���Դ
		rs.close();
		statement.close();
		conn.close();//����Ҫ�صģ��������������ޣ��������ݿ�������
	}

	/**
	 * �淶д��
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//�����ȼ��ؾ�̬������е����ݣ���ΪOracleDriver�ľ�̬���������DriverManager.registerDriver(new OracleDriver());
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="zicheng";
			String pwd="qqq";
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("���ӳɹ���");
			String sql = "select * from emp where ename like '%A%'";
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()){//����������ƶ�һ�в��ж��Ƿ���ڡ��������򷵻�true�����򷵻�false��
				int empno = rs.getInt(1);//ͨ���б������ȡ���е�ֵ
				String ename = rs.getString("ename");//ͨ����������ȡ���е�ֵ��
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


