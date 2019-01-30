package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import entity.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao aDao = new AdminDaoImpl();
	@Override
	public Admin selectAdminByAP(String admin_code, String password) {
		Admin admin = null;
		try {
			admin = aDao.selectAdminByAP(admin_code, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

}
