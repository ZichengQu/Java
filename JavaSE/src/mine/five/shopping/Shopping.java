package mine.five.shopping;

import java.util.Scanner;

public class Shopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("n �˳���\n������ʾ�˵���");
		Scanner in = new Scanner(System.in);
		
		String choice = in.next();
		while((!"n".equals(choice))){	
			System.out.println("��ӭʹ��Ǭ���̳ǹ���ϵͳ\n"
					+ "1��T��\t��198.00\n"
					+ "2������\t��588.88\n"
					+ "3��ipad\t��2018.18");
			choice = in.next();
		}
		System.out.println("����");
	}

}
