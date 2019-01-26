package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.bean.Emp;
import com.dao.EmpDao;
import com.dao.impl.EmpDaoImpl;
import com.service.EmpService;

public class EmpServiceImpl implements EmpService {
	private EmpDao eDao = new EmpDaoImpl();
	@Override
	public List<Emp> selAllEmp(){
		List<Emp> list = new ArrayList<Emp>();
		try {
			list = eDao.selAllEmp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Emp> queryEmpByEname(String ename) {
		List<Emp> list = new ArrayList<Emp>();
		try {
			list = eDao.queryEmpByEname(ename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Emp> selEmpByCondition(String condition, String value) {
		List<Emp> list = new ArrayList<Emp>();
		try {
			list = eDao.selEmpByCondition(condition, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean delEmpById(int empno) {
		try {
			int num = eDao.delEmpById(empno);
			if(num>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public int addEmp(Emp emp) {
		int num = 0;
		try {
			num = eDao.addEmp(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	@Override
	public List<Emp> selMgrByDept(int deptno) {
		List<Emp> list = new ArrayList<Emp>();
		try {
			list = eDao.selMgrByDept(deptno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
