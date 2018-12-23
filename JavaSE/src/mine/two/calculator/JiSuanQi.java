package mine.two.calculator;

import java.util.Scanner;

public class JiSuanQi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("¼ÆËãÆ÷£º");
		Scanner in = new Scanner(System.in);
		int number1 = in.nextInt();
		String sign = in.next();
		int number2 = in.nextInt();
		int number3 = 0;
		switch(sign){
		case "+":
		    number3 = number1 + number2;
		    break;
		case "-":
			number3 = number1 - number2;
		    break;
		case "*":
			number3 = number1 * number2;
		    break;
		case "/":
			number3 = number1 / number2;
		    break;
		default:
		    //...;
		    break;
		}
		System.out.println(number3);
	}

}
