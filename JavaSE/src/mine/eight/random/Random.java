package mine.eight.random;

import java.util.Scanner;

public class Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = (int) (Math.random()*5);//[0,5)
		String[] name = {"����","����","����","С��","������"};
		System.out.print("1.�齱\t2.�˳�");
		int num = sc.nextInt();
		if(num==1){
			System.out.println("�����û�Ϊ��"+ name[number]);
		}else{
			System.out.println("�˳��齱ϵͳ.");
		}
	}

}
