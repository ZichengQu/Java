package project.EmpManage_JDBC.dao;

import java.util.*;

import project.EmpManage_JDBC.bean.Emp;

/*
 * JavaEE三层结构
 * 		dao层：dao层和数据库进行交互
 * 		service层：业务逻辑处理
 * 		web层：：数据展示
 * 员工管理系统需求：
 * 		1.查询所有员工
 * 		2.查询指定编号的员工
 * 		3.添加员工信息
 * 		4.删除指定编号的员工
 */
public interface EmpDao {
	
	public Emp findOneEmp(int empno);//查询指定编号的员工
	public List<Emp> findAllEmp();//查询所有员工
	public List<Emp> selEmpInfo();//查询员工编号，姓名，工资，部门编号，部门名称
	public List<Emp> selEmpByPage(int page,int pageSize);//分页查询
	public List<Emp> fuzzyQuery(String str);//模糊查询
	public int saveEmp(Emp e);//添加员工信息
	public int deleteEmp(int empno);//删除指定编号的员工		
	public int updateEmp(Emp emp);//修改员工职位、工资、津贴
	
}
