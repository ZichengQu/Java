package dao;

import entity.Admin;

public interface AdminDao {
	public Admin selectAdminByAP(String admin_code, String password) throws Exception;//����admin_code��password��ѯ������ָ���û���
}
