package mine.twentyOne.map;

import java.util.*;

public class mapDemo {//21��

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String[]> city = new HashMap<String, String[]>();
		city.put("����ʡ", new String[]{"����","����","����"});
		city.put("�ӱ�ʡ", new String[]{"ʯ��ׯ","����","��ˮ"});
		city.put("null", new String[]{"����","�Ϻ�","���","����"});
		
		System.out.println("������һ��ʡ�ݣ�");
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String[] cities = city.get(a);
		System.out.println(Arrays.toString(cities));	
	}
}
