package mine.seven.login;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username = "Tom";
		String password = "Tom123";
		
		
		Scanner in = new Scanner(System.in);
		
		while(true){
			System.out.println("�������û�����");
			String user = in.nextLine();
			if((!user.equals(username))){
				System.out.println("�û����������������룺");
				continue;
			}
			System.out.println("���������룺");
			String pwd = in.nextLine();
			if((!pwd.equals(password))){
				System.out.println("����������������룺");
				continue;
			}else{
				System.out.println("��½�ɹ���");
				break;
			}
		}
		
	}

}
