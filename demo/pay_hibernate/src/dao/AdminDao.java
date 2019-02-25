package dao;

import entity.Admin;

public interface AdminDao {
	public Admin selectAdminByCode(String admin_code);//根据admin_code和password查询并返回指定用户。
}
