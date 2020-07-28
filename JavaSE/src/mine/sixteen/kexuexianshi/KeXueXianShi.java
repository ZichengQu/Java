package mine.sixteen.kexuexianshi;

import java.util.Scanner;

public class KeXueXianShi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ÇëÊäÈëÒ»´®Êı×Ö: ");
		Scanner in = new Scanner(System.in);		
		String number = in.nextLine();
		StringBuffer number2 = new StringBuffer(number);
		int count = number.length()%3;
		
		for(int i=count; i<number.length()*4/3-1; i+=4){
			number2.insert(i,".");
		}
		
		System.out.println(number2);
	}

}
