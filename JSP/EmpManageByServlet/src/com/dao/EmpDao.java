package com.dao;

import java.util.List;

import com.bean.Emp;

public interface EmpDao {
	public List<Emp> selAllEmp() throws Exception;//查询所有员工信息
	public List<Emp> queryEmpByEname(String ename) throws Exception;//模糊查询员工姓名
	public List<Emp> selEmpByCondition(String condition, String value) throws Exception;//条件查询
	public int delEmpById(int empno) throws Exception;//删除
	public int addEmp(Emp emp) throws Exception;
	public List<Emp> selMgrByDept(int deptno) throws Exception;//addEmp.jsp中添加员工时根据选择的部门号利用ajax显示不同的mgr。
}
