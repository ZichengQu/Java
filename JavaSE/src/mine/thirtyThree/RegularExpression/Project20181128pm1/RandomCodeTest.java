package mine.thirtyThree.RegularExpression.Project20181128pm1;
import java.util.Random;
import java.util.Scanner;

public class RandomCodeTest {

	public static void main(String[] args) {
		RandomCode rc = new RandomCode();
		rc.run();
		System.out.print("请输入四位验证码: ");
		Scanner in = new Scanner(System.in);
		System.out.println("输入是否和随机码一致: "+rc.isRight(in.next()));		
	}
	
	
}
