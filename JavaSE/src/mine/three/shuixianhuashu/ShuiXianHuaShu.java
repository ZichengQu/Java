package mine.three.shuixianhuashu;

import java.util.Scanner;

public class ShuiXianHuaShu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[100,1000)之间的所有水仙花数: ");
		for(int i=100; i<1000; i++){
			int hundred = i/100;
			int ten = i%100/10;
			int one = i%100%10;
			int number = (int) (Math.pow(hundred,3)+ Math.pow(ten,3) +Math.pow(one,3));
			if(number == i){
				System.out.print(i+" ");
			}
		}
		
	}

}
