package mine.eleven.staticdemo;

import java.util.Scanner;

public class StaticDemo {
	private static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("��ͶƱ: ");
		Scanner in = new Scanner(System.in);
		int choice;
		while(count<=100){
			System.out.println("��ѯ��ǰƱ�������룺 chaxun\nͶƱ�����룺toupiao");
			String check = in.nextLine();
			if("chaxun".equals(check)){
				System.out.println("��ǰƱ��Ϊ��"+count);
			}else if("toupiao".equals(check)){
				System.out.println("��ͶƱ: ");
				choice = in.nextInt();
				System.out.println("��лͶƱ��");
				count++;
			}else{
				System.out.println("��Чָ����������룡");
			}
		}
		System.out.println("��ʾͶƱ�ѽ�����");
	}

}
