package com.service;

import java.util.List;

import com.bean.Emp;

public interface EmpService {
	public List<Emp> selAllEmp();
	public List<Emp> queryEmpByEname(String ename);
	public List<Emp> selEmpByCondition(String condition, String value);
	public boolean delEmpById(int empno);
	public int addEmp(Emp emp);
	public List<Emp> selMgrByDept(int deptno);
}
