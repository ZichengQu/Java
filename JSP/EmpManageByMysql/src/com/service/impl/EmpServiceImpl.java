package com.service.impl;

import java.util.List;

import com.bean.Emp;
import com.bean.PageBean;
import com.dao.EmpDao;
import com.dao.impl.EmpDaoImpl;
import com.service.EmpService;

public class EmpServiceImpl implements EmpService {
	
	@Override
	public List<Emp> selAllEmp() {
		EmpDao eDao = new EmpDaoImpl();
		List<Emp> list = null;
		try {
			list = eDao.selAllEmp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Emp> selEmpByPage(PageBean pBean) {
		EmpDao eDao = new EmpDaoImpl();
		List<Emp> list = null;
		try {
			list = eDao.selEmpByPage(pBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
