package mine.one.pingrunnian;

import java.util.Scanner;

public class PingRunNian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("year:");
		int year = in.nextInt();
		if(year%4 !=0){
			System.out.println("不是闰年");
		}else if(year%100 == 0 ){
			System.out.println("不是闰年");
		}else{
			System.out.println("是闰年");
		}
	}

}
