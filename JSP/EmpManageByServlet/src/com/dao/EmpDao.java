package com.dao;

import java.util.List;

import com.bean.Emp;

public interface EmpDao {
	public List<Emp> selAllEmp() throws Exception;//��ѯ����Ա����Ϣ
	public List<Emp> queryEmpByEname(String ename) throws Exception;//ģ����ѯԱ������
	public List<Emp> selEmpByCondition(String condition, String value) throws Exception;//������ѯ
	public int delEmpById(int empno) throws Exception;//ɾ��
	public int addEmp(Emp emp) throws Exception;
}
