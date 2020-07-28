package mine.eleven.staticdemo;

import java.util.Scanner;

public class StaticDemo {
	private static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请投票: ");
		Scanner in = new Scanner(System.in);
		int choice;
		while(count<=100){
			System.out.println("查询当前票数请输入： chaxun\n投票请输入：toupiao");
			String check = in.nextLine();
			if("chaxun".equals(check)){
				System.out.println("当前票数为："+count);
			}else if("toupiao".equals(check)){
				System.out.println("请投票: ");
				choice = in.nextInt();
				System.out.println("感谢投票！");
				count++;
			}else{
				System.out.println("无效指令，请重新输入！");
			}
		}
		System.out.println("提示投票已结束！");
	}

}
