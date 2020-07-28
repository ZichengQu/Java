package mine.thirtyThree.RegularExpression.Project20181128pm1;
import java.util.Arrays;
import java.util.Random;

public class RandomCode {
	private String randomCode;
	
	public RandomCode() {
		super();
	}

	public void run() {
		//A-Z:65-90, a-z:97-122, 0-9:48-57
		randomCode = code();
		System.out.println("生成的随机码为: "+randomCode);		
	}
	
	public String code(){
		Random random = new Random();		
		char[] c = new char[4];	
		int index = 0;
		while(true){
			int r = random.nextInt(123);
			if (r>=65&&r<=90) {
				c[index++] = (char)r;
			}else if (r>=97&&r<=122) {
				c[index++] = (char)r;
			}else if (r>=48&&r<=57) {
				c[index++] = (char)r;
			}
			if(index == 4){
				break;
			}
		}
		return String.valueOf(c);
	}
	
	public boolean isRight(String str){	
		return randomCode.equalsIgnoreCase(str);
	}
}
