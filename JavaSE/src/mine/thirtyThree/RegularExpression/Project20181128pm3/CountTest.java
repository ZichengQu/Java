package mine.thirtyThree.RegularExpression.Project20181128pm3;

import java.util.Scanner;

public class CountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("请输入一个字符串: ");
		Scanner in = new Scanner(System.in);
		GCount gc = new GCount(in.next());
		System.out.println("g的个数为:"+gc.gCount());
	}

}
