package mine.five.shopping;

import java.util.Scanner;

public class Shopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("n 退出：\n其他显示菜单：");
		Scanner in = new Scanner(System.in);
		
		String choice = in.next();
		while((!"n".equals(choice))){	
			System.out.println("欢迎使用乾包商城购物系统\n"
					+ "1）T恤\t￥198.00\n"
					+ "2）篮球\t￥588.88\n"
					+ "3）ipad\t￥2018.18");
			choice = in.next();
		}
		System.out.println("结束");
	}

}
