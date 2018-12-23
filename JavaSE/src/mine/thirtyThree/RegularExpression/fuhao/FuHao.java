package mine.thirtyThree.RegularExpression.fuhao;

import java.util.Arrays;
import java.util.Scanner;

public class FuHao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("«Î ‰»Î“ª¥Æ◊÷∑˚: ");
		Scanner in = new Scanner(System.in);		
		String s = in.next();
		String capLetter = "[A-Z]";
		String uncapLetter = "[a-z]";
		String number = "\\d";
		String character = "[\u4e00-\u9fa5]";
		String sign = ".";
		
		int daXie=0, xiaoXie=0, shuZi=0, hanZi=0, fuHao=0;
		char[] s2 = s.toCharArray();
		
		for(int i=0; i<s.length(); i++){
			String t = String.valueOf(s2[i]);
			if(t.matches(capLetter)){
				daXie++;
			}else if(t.matches(uncapLetter)){
				xiaoXie++;
			}else if(t.matches(number)){
				shuZi++;
			}else if(t.matches(character)){
				hanZi++;
			}else if(t.matches(sign)){
				fuHao++;
			}
		}
		System.out.printf("¥Û–¥◊÷ƒ∏: %d, –°–¥◊÷ƒ∏: %d,Ãÿ ‚∑˚∫≈: %d, ˝◊÷: %d,∫∫◊÷: %d\n",daXie, xiaoXie, fuHao, shuZi, hanZi);
	}

}
