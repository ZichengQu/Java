package mine.thirtyFour.StringBufferCollection;


import java.util.*;

public class Question6and7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "52 -5 02 11 99 -100";
		String str2 = "52 -5 2 11 99 -10";
		str1 = sortString(str1);
		str2 = sortString(str2);
		System.out.println(str1+"\n"+str2);
	}

	public static String sortString(String str){
		String[] str1 = str.split(" ");
		List<String> str2 = Arrays.asList(str1);
		Collections.sort(str2);
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<str2.size(); i++){
			sb.append(str2.get(i)+" ");
		}
		str = sb.substring(0,sb.length()-1);
		return str;
	}
}
