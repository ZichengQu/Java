package mine.twentyNine.breakWhileA;

import java.util.Scanner;

public class Demo {
	
	static String name = "ahah";
	static String pad = "123";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		a:while(true){
			System.out.print("name:");
			String userName = sc.next();
			if(userName.equals(name)){
				while(true){
					System.out.print("pad:");
					String password = sc.next();
					if(password.equals(pad)){
						System.out.println("fskdhfkals");
						break a;
					}else{
						System.out.println("errorPad");
					}
				}
			}else{
				System.out.println("errorName");
			}
		}
		
	}
}
