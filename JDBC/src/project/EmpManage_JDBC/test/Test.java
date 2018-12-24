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
				System.out.println("退出系统.");
				return;	
			default:
				System.out.println("没有找到你要执行的操作.");
				break;
			}
		}						
	}	
	
	public static int menu(){//菜单
		System.out.println("----------欢迎使用员工管理系统-------------");
		System.out.println("功能菜单： ");
		System.out.println("\t1.查询指定编号的员工信息");
		System.out.println("\t2.查询所有员工信息");
		System.out.println("\t3.查询员工编号，姓名，工资，部门编号，部门名称");
		System.out.println("\t4.分页查询所有员工信息");
		System.out.println("\t5.模糊查询");
		System.out.println("\t6.添加员工信息");
		System.out.println("\t7.删除员工信息");
		System.out.println("\t8.修改员工信息");
		System.out.println("\t9.退出系统");
		System.out.print("请选择你要执行的操作：");
		return new Scanner(System.in).nextInt();
	}
	
	public static void findOneEmp(){//查询指定编号的员工
		//1.从控制台录入要查询的员工编号：
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入要查询的员工编号：");
		int empno = sc.nextInt();
		//2.调用dao层方法：
		EmpDao ed = new EmpDaoImpl();
		Emp emp = ed.findOneEmp(empno);
		if(emp!=null){
			System.out.println(emp);
		}else{
			System.out.println("你要查询的员工不存在!");
		}
	}
	
	public static void findAllEmp(){//查询所有员工
		List<Emp> list = new EmpDaoImpl().findAllEmp();
		System.out.println("员工信息如下：一共("+list.size()+")人");
		if(!list.isEmpty()){
			for(Emp e: list){
				System.out.println(e);
			}
		}else{
			System.out.println("无");
		}
	}

	public static void selEmpInfo(){//查询员工编号，姓名，工资，部门编号，部门名称
		EmpDao ed = new EmpDaoImpl();
		for(Emp emp: ed.selEmpInfo()){
			System.out.println(emp);
		}
	}
	
	public static void selEmpByPage(){//分页查询
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入页数：");
		int page = sc.nextInt();
		EmpDao ed = new EmpDaoImpl();
		List<Emp> list = ed.selEmpByPage(page, 5);
		for(Emp emp: list){
			System.out.println(emp);
		}
	}
	
	public static void fuzzyQuery(){//模糊查询
		System.out.print("请输入要查询的员工姓名(支持模糊查询)：");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		EmpDao ed = new EmpDaoImpl();
		List<Emp> list = ed.fuzzyQuery(str);
		for(Emp emp: list){
			System.out.println(emp);
		}
	}
		
	public static void saveEmp(){//添加员工信息
		Emp emp = new Emp();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("员工编号： ");
		emp.setEmpno(sc.nextInt());
		System.out.print("员工姓名： ");
		emp.setEname(sc.next());
		System.out.print("员工职位： ");
		emp.setJob(sc.next());
		System.out.print("员工的经理编号： ");
		emp.setMgr(sc.nextInt());
		System.out.print("员工入职时间： ");		
		try {//String--->util.Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			emp.setHiredate(sdf.parse(sc.next()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.print("员工工资： ");
		emp.setSal(sc.nextDouble());
		System.out.print("员工奖金： ");
		emp.setComm(sc.nextDouble());
		System.out.print("员工部门编号： ");
		emp.setDeptno(sc.nextInt());
		
		EmpDao ed = new EmpDaoImpl();
		int a = ed.saveEmp(emp);
		System.out.println(a>0?"插入成功!":"插入失败!");
	}
	
	public static void deleteEmp(){//删除指定编号的员工
		System.out.print("员工编号： ");
		int empno = new Scanner(System.in).nextInt();
		EmpDao ed = new EmpDaoImpl();
		int rows = ed.deleteEmp(empno);
		System.out.println(rows>0?"删除成功!":"删除失败!");
	}

	public static void updateEmp(){//修改员工职位、工资、津贴
		EmpDao ed = new EmpDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("员工编号： ");
		Emp emp = ed.findOneEmp(sc.nextInt());
		System.out.println(emp);
		System.out.print("员工职位： ");
		emp.setJob(sc.next());
		System.out.print("员工工资： ");
		emp.setSal(sc.nextDouble());
		System.out.print("员工奖金： ");
		emp.setComm(sc.nextDouble());
		int a = ed.updateEmp(emp);
		System.out.println(a>0?"更新成功!":"更新失败!");
	}

}
