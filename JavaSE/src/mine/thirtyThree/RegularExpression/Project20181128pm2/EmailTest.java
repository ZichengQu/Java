package mine.thirtyThree.RegularExpression.Project20181128pm2;

import java.util.Scanner;

public class EmailTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("请输入邮箱地址: ");
		Scanner in = new Scanner(System.in);
		Email e = new Email(in.next());
		//e.isStyle();
		System.out.println(e.isStyle()?"此邮箱地址有效。":"此邮箱地址无效。");
	}
}
