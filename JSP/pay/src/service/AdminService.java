package service;

import entity.Admin;

public interface AdminService {
	public Admin selectAdminByAP(String admin_code, String password);
}
