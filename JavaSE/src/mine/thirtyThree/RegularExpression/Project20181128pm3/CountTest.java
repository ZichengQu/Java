package mine.thirtyThree.RegularExpression.Project20181128pm3;

import java.util.Scanner;

public class CountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("������һ���ַ���: ");
		Scanner in = new Scanner(System.in);
		GCount gc = new GCount(in.next());
		System.out.println("g�ĸ���Ϊ:"+gc.gCount());
	}

}
