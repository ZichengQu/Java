package com.dao;

import java.util.List;

import com.bean.Emp;
import com.bean.PageBean;

public interface EmpDao {
	public List<Emp> selAllEmp() throws Exception;
	public List<Emp> selEmpByPage(PageBean pBean) throws Exception;
}
