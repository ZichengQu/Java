package dao;

import entity.Admin;

public interface AdminDao {
	public Admin selectAdminByCode(String admin_code);//����admin_code��password��ѯ������ָ���û���
}
