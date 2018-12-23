package mine.fifteen.zhihuan;

import java.util.Arrays;
import java.util.Scanner;

public class ZhiHuan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ÇëÊäÈëÒ»´®Êı×Ö:");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		String number2 = String.valueOf(number);
		char[] number3 = new char[number2.length()];
		number3 = number2.toCharArray();
		char t;
		for(int i=0; i<(number3.length+1)/2-1; i++){
			t = number3[number3.length-1-i];
			number3[number3.length-1-i] = number3[i];
			number3[i] = t;
		}
		number2 = String.valueOf(number3);
		number = Integer.parseInt(number2);
		System.out.println(number);
	}

}
