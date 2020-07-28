package mine.twentyOne.map;

import java.util.*;

public class mapDemo {//21题

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String[]> city = new HashMap<String, String[]>();
		city.put("辽宁省", new String[]{"沈阳","大连","锦州"});
		city.put("河北省", new String[]{"石家庄","保定","衡水"});
		city.put("null", new String[]{"北京","上海","天津","重庆"});
		
		System.out.println("请输入一个省份：");
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String[] cities = city.get(a);
		System.out.println(Arrays.toString(cities));	
	}
}
