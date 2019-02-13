package service;

import entity.Admin;

public interface AdminService {
	public Admin selectAdminByCode(String admin_code);
}
