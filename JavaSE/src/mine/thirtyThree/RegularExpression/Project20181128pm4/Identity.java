package mine.thirtyThree.RegularExpression.Project20181128pm4;

import java.util.Scanner;

public class Identity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入身份证号: ");
		Scanner in = new Scanner(System.in);		
		String s = in.next();
		String identity = "\\d{17}[A-Za-z0-9]";
		System.out.println(s.matches(identity));
		
		System.out.println("请输入QQ号: ");
		String s1 = in.next();
		String qqFormat = "[1-9]\\d{4,9}";
		System.out.println(s1.matches(qqFormat));
	}

}
