package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Dept;
import com.dao.DeptDao;
import com.dao.impl.DeptDaoImpl;
import com.service.DeptService;

public class DeptServiceImpl implements DeptService {
	DeptDao dd = new DeptDaoImpl();
	
	@Override
	public List<Dept> selAllDept() {
		List<Dept> list = null;
		try {
			list = dd.selAllDept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
