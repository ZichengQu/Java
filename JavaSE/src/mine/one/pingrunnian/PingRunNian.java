package mine.one.pingrunnian;

import java.util.Scanner;

public class PingRunNian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("year:");
		int year = in.nextInt();
		if(year%4 !=0){
			System.out.println("��������");
		}else if(year%100 == 0 ){
			System.out.println("��������");
		}else{
			System.out.println("������");
		}
	}

}
