package mine.thirtyThree.RegularExpression.Project20181128pm1;
import java.util.Random;
import java.util.Scanner;

public class RandomCodeTest {

	public static void main(String[] args) {
		RandomCode rc = new RandomCode();
		rc.run();
		System.out.print("��������λ��֤��: ");
		Scanner in = new Scanner(System.in);
		System.out.println("�����Ƿ�������һ��: "+rc.isRight(in.next()));		
	}
	
	
}
