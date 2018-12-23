package mine.eight.random;

import java.util.Scanner;

public class Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = (int) (Math.random()*5);//[0,5)
		String[] name = {"张三","李四","王五","小明","武丽娟"};
		System.out.print("1.抽奖\t2.退出");
		int num = sc.nextInt();
		if(num==1){
			System.out.println("幸运用户为："+ name[number]);
		}else{
			System.out.println("退出抽奖系统.");
		}
	}

}
