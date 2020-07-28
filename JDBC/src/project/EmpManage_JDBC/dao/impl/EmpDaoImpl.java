package project.EmpManage_JDBC.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.experimental.theories.FromDataPoints;

import project.EmpManage_JDBC.bean.Dept;
import project.EmpManage_JDBC.bean.Emp;
import project.EmpManage_JDBC.dao.EmpDao;
import project.EmpManage_JDBC.util.DBUtil;

public class EmpDaoImpl implements EmpDao{

	@Override
	public Emp findOneEmp(int empno) {//��ѯָ��Ա��
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = null;
		try{
			//1.�������Ӷ���
			conn = DBUtil.getConnection();
			String sql = "select * from emp where empno=?";
			//2.����Ԥ�������
			ps = conn.prepareStatement(sql);
			//3.��ֵ
			ps.setInt(1, empno);
			//4.ִ��sql���
			rs = ps.executeQuery();
			if(rs.next()){//5.���������,����һ��,���Կ���дif
				int eno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");
				emp = new Emp(eno, ename, job, mgr, hiredate, sal, comm, deptno);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		return emp;
	}

	@Override
	public List<Emp> findAllEmp() {//��ѯ����Ա��
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList<Emp>(); 
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int eno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");
				list.add(new Emp(eno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public List<Emp> selEmpInfo() {//��ѯԱ����ţ����������ʣ����ű�ţ���������
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList<Emp>();
		try {
			conn = DBUtil.getConnection();
			String sql = "select ename,sal,e.deptno dno,dname "
					+ "from emp e,dept d where e.deptno=d.deptno";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String ename=rs.getString("ename");
				double sal = rs.getDouble("sal");
				int deptno = rs.getInt("dno");
				String dname = rs.getString("dname");
				Emp emp = new Emp(0, ename, null, 0, null, sal, 0, deptno);
				Dept dept = new Dept(deptno, dname, null);
				emp.setDept(dept);
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}		
		return list;
	}
	
	@Override
	public List<Emp> selEmpByPage(int page, int pageSize) {//��ҳ��ѯ
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList<Emp>();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from "
					+ "(select rownum rn, e.* from "
					+ "(select * from emp order by sal desc) e where rownum<=?)t "
					+ "where t.rn>=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, (page-1)*pageSize+1);
			rs = ps.executeQuery();
			while(rs.next()){
				int rownum = rs.getInt("rn");
				int eno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");
				list.add(new Emp(eno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		
		
		return list;
	}
	
	@Override
	public List<Emp> fuzzyQuery(String str) {//ģ����ѯ
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList<Emp>(); 
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from emp where ename like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+str+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				int eno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");
				list.add(new Emp(eno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public int saveEmp(Emp emp) {//ʹ�ù�����DBUtil�е�executeUpdate����
		String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
		//util.Date-->sql.Date
		java.sql.Date date = new java.sql.Date(emp.getHiredate().getTime());
		Object[] obj = {emp.getEmpno(),
						emp.getEname(),
						emp.getJob(),
						emp.getMgr(),
						date,
						emp.getSal(),
						emp.getComm(),
						emp.getDeptno()};
		return DBUtil.executeUpdate(sql, obj);
	}

	@Override
	public int deleteEmp(int empno) {//ʹ�ù�����DBUtil�е�executeUpdate����
		String sql = "delete from emp where empno=?";
		Object[] obj = {empno};
		return DBUtil.executeUpdate(sql, obj);
	}
	
	@Override
	public int updateEmp(Emp emp) {//����ʹ�õ��ǳ��淽�����и��£�Ҳ��ʹ�ù�����DBUtil�е�executeUpdate����
		Connection conn = null;
		PreparedStatement ps = null;
		int rows = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "update emp set job=?,sal=?,comm=? where empno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getJob());
			ps.setDouble(2, emp.getSal());
			ps.setDouble(3, emp.getComm());
			ps.setInt(4, emp.getEmpno());
			rows = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, null);
		}
		return rows;
	}

	
}
