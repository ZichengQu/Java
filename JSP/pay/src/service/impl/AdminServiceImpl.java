package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import entity.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao aDao = new AdminDaoImpl();
	@Override
	public Admin selectAdminByCode(String admin_code) {
		Admin admin = null;
		try {
			admin = aDao.selectAdminByCode(admin_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

}
