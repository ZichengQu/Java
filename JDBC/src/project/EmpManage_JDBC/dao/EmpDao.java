package project.EmpManage_JDBC.dao;

import java.util.*;

import project.EmpManage_JDBC.bean.Emp;

/*
 * JavaEE����ṹ
 * 		dao�㣺dao������ݿ���н���
 * 		service�㣺ҵ���߼�����
 * 		web�㣺������չʾ
 * Ա������ϵͳ����
 * 		1.��ѯ����Ա��
 * 		2.��ѯָ����ŵ�Ա��
 * 		3.���Ա����Ϣ
 * 		4.ɾ��ָ����ŵ�Ա��
 */
public interface EmpDao {
	
	public Emp findOneEmp(int empno);//��ѯָ����ŵ�Ա��
	public List<Emp> findAllEmp();//��ѯ����Ա��
	public List<Emp> selEmpInfo();//��ѯԱ����ţ����������ʣ����ű�ţ���������
	public List<Emp> selEmpByPage(int page,int pageSize);//��ҳ��ѯ
	public List<Emp> fuzzyQuery(String str);//ģ����ѯ
	public int saveEmp(Emp e);//���Ա����Ϣ
	public int deleteEmp(int empno);//ɾ��ָ����ŵ�Ա��		
	public int updateEmp(Emp emp);//�޸�Ա��ְλ�����ʡ�����
	
}
