package mine.fourteen.zimu;

import java.util.Scanner;

public class ZiMu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������һ����ĸ:");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		char[] aCount = input.toCharArray();
		int count = 0;
		for(int i=0; i<input.length(); i++){
			if(aCount[i]=='a'){
				count++;			
			}
		}
		System.out.println("��ĸa�ĸ���Ϊ:"+count);
	}
}