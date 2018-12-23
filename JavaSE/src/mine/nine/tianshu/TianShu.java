package mine.nine.tianshu;

import java.util.Scanner;

public class TianShu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] day = {31,28,31,30,31,30,31,31,30,31,30,31};
		Scanner in = new Scanner(System.in);
		System.out.println("year:");
		int year = in.nextInt();
		System.out.println("m:");
		int month = in.nextInt();
		System.out.println("d:");
		int date = in.nextInt();
		if(year%400==0 || (year%4 ==0 && year%100 != 0)){
			day = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
		}
		int number = 0;
		for(int i=0; i<month-1; i++){
			number += day[i];
		}
		System.out.println(number+date);
	}

}
