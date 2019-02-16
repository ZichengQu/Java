package com.service;

import java.util.List;

import com.bean.Emp;
import com.bean.PageBean;

public interface EmpService {
	public List<Emp> selAllEmp();
	public List<Emp> selEmpByPage(PageBean pBean);
}
