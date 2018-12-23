package mine.seven.login;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username = "Tom";
		String password = "Tom123";
		
		
		Scanner in = new Scanner(System.in);
		
		while(true){
			System.out.println("请输入用户名：");
			String user = in.nextLine();
			if((!user.equals(username))){
				System.out.println("用户名错误，请重新输入：");
				continue;
			}
			System.out.println("请输入密码：");
			String pwd = in.nextLine();
			if((!pwd.equals(password))){
				System.out.println("密码错误，请重新输入：");
				continue;
			}else{
				System.out.println("登陆成功！");
				break;
			}
		}
		
	}

}
