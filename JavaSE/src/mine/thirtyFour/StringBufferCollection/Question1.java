package mine.thirtyFour.StringBufferCollection;


import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("«Î ‰»Î“ª¥Æ ˝◊÷: ");
		Scanner in = new Scanner(System.in);		
		Integer number = in.nextInt();
		StringBuffer sbuf = new StringBuffer(number.toString());
//		int count = number.length()%3;
//		count = (count==0) ? 3: count;		
//		for(int i=count; i<number.length()*4/3-1; i+=4){
//			number2.insert(i,".");
//		}
		for(int i=sbuf.length()-3;i>0;i-=3){
			sbuf.insert(i, ",");
		}
		System.out.println(sbuf.toString());
	}

}
