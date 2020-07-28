package project.EmpManage_JDBC.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import project.EmpManage_JDBC.bean.Emp;
import project.EmpManage_JDBC.dao.EmpDao;
import project.EmpManage_JDBC.dao.impl.EmpDaoImpl;

public class Test {

	public static void main(String[] args) {
		while(true){			
			int choose = menu();
			switch (choose) {
			case 1:
				findOneEmp();								
				break;
			case 2:
				findAllEmp();
				break;	
			case 3:
				selEmpInfo();
				break;
			case 4:
				fuzzyQuery();
				break;			
			case 5:
				selEmpByPage();
				break;	
			case 6:
				saveEmp();
				break;
			case 7:
				deleteEmp();
				break;
			case 8:
				updateEmp();
				break;
			case 9:			
				System.out.println("�˳�ϵͳ.");
				return;	
			default:
				System.out.println("û���ҵ���Ҫִ�еĲ���.");
				break;
			}
		}						
	}	
	
	public static int menu(){//�˵�
		System.out.println("----------��ӭʹ��Ա������ϵͳ-------------");
		System.out.println("���ܲ˵��� ");
		System.out.println("\t1.��ѯָ����ŵ�Ա����Ϣ");
		System.out.println("\t2.��ѯ����Ա����Ϣ");
		System.out.println("\t3.��ѯԱ����ţ����������ʣ����ű�ţ���������");
		System.out.println("\t4.��ҳ��ѯ����Ա����Ϣ");
		System.out.println("\t5.ģ����ѯ");
		System.out.println("\t6.���Ա����Ϣ");
		System.out.println("\t7.ɾ��Ա����Ϣ");
		System.out.println("\t8.�޸�Ա����Ϣ");
		System.out.println("\t9.�˳�ϵͳ");
		System.out.print("��ѡ����Ҫִ�еĲ�����");
		return new Scanner(System.in).nextInt();
	}
	
	public static void findOneEmp(){//��ѯָ����ŵ�Ա��
		//1.�ӿ���̨¼��Ҫ��ѯ��Ա����ţ�
		Scanner sc = new Scanner(System.in);
		System.out.print("������Ҫ��ѯ��Ա����ţ�");
		int empno = sc.nextInt();
		//2.����dao�㷽����
		EmpDao ed = new EmpDaoImpl();
		Emp emp = ed.findOneEmp(empno);
		if(emp!=null){
			System.out.println(emp);
		}else{
			System.out.println("��Ҫ��ѯ��Ա��������!");
		}
	}
	
	public static void findAllEmp(){//��ѯ����Ա��
		List<Emp> list = new EmpDaoImpl().findAllEmp();
		System.out.println("Ա����Ϣ���£�һ��("+list.size()+")��");
		if(!list.isEmpty()){
			for(Emp e: list){
				System.out.println(e);
			}
		}else{
			System.out.println("��");
		}
	}

	public static void selEmpInfo(){//��ѯԱ����ţ����������ʣ����ű�ţ���������
		EmpDao ed = new EmpDaoImpl();
		for(Emp emp: ed.selEmpInfo()){
			System.out.println(emp);
		}
	}
	
	public static void selEmpByPage(){//��ҳ��ѯ
		Scanner sc = new Scanner(System.in);
		System.out.print("������ҳ����");
		int page = sc.nextInt();
		EmpDao ed = new EmpDaoImpl();
		List<Emp> list = ed.selEmpByPage(page, 5);
		for(Emp emp: list){
			System.out.println(emp);
		}
	}
	
	public static void fuzzyQuery(){//ģ����ѯ
		System.out.print("������Ҫ��ѯ��Ա������(֧��ģ����ѯ)��");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		EmpDao ed = new EmpDaoImpl();
		List<Emp> list = ed.fuzzyQuery(str);
		for(Emp emp: list){
			System.out.println(emp);
		}
	}
		
	public static void saveEmp(){//���Ա����Ϣ
		Emp emp = new Emp();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ա����ţ� ");
		emp.setEmpno(sc.nextInt());
		System.out.print("Ա�������� ");
		emp.setEname(sc.next());
		System.out.print("Ա��ְλ�� ");
		emp.setJob(sc.next());
		System.out.print("Ա���ľ����ţ� ");
		emp.setMgr(sc.nextInt());
		System.out.print("Ա����ְʱ�䣺 ");		
		try {//String--->util.Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			emp.setHiredate(sdf.parse(sc.next()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.print("Ա�����ʣ� ");
		emp.setSal(sc.nextDouble());
		System.out.print("Ա������ ");
		emp.setComm(sc.nextDouble());
		System.out.print("Ա�����ű�ţ� ");
		emp.setDeptno(sc.nextInt());
		
		EmpDao ed = new EmpDaoImpl();
		int a = ed.saveEmp(emp);
		System.out.println(a>0?"����ɹ�!":"����ʧ��!");
	}
	
	public static void deleteEmp(){//ɾ��ָ����ŵ�Ա��
		System.out.print("Ա����ţ� ");
		int empno = new Scanner(System.in).nextInt();
		EmpDao ed = new EmpDaoImpl();
		int rows = ed.deleteEmp(empno);
		System.out.println(rows>0?"ɾ���ɹ�!":"ɾ��ʧ��!");
	}

	public static void updateEmp(){//�޸�Ա��ְλ�����ʡ�����
		EmpDao ed = new EmpDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ա����ţ� ");
		Emp emp = ed.findOneEmp(sc.nextInt());
		System.out.println(emp);
		System.out.print("Ա��ְλ�� ");
		emp.setJob(sc.next());
		System.out.print("Ա�����ʣ� ");
		emp.setSal(sc.nextDouble());
		System.out.print("Ա������ ");
		emp.setComm(sc.nextDouble());
		int a = ed.updateEmp(emp);
		System.out.println(a>0?"���³ɹ�!":"����ʧ��!");
	}

}
