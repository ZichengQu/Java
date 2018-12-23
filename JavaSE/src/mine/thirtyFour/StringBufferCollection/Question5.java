package mine.thirtyFour.StringBufferCollection;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String[]> provience = new HashMap<String, String[]>();
		provience.put("辽宁省", new String[]{"沈阳","大连","锦州"});
		provience.put("河北省", new String[]{"石家庄","保定","衡水"});
		provience.put("null", new String[]{"北京","上海","天津","重庆"});
		
		System.out.println("请输入一个省份：");
		Scanner in = new Scanner(System.in);
		String input = in.next();
		String[] cities = provience.get(input);
		System.out.println(cities==null? "没有你要去的省份.":Arrays.toString(cities));
	}

}
