package mine.thirtyFour.StringBufferCollection;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String[]> provience = new HashMap<String, String[]>();
		provience.put("����ʡ", new String[]{"����","����","����"});
		provience.put("�ӱ�ʡ", new String[]{"ʯ��ׯ","����","��ˮ"});
		provience.put("null", new String[]{"����","�Ϻ�","���","����"});
		
		System.out.println("������һ��ʡ�ݣ�");
		Scanner in = new Scanner(System.in);
		String input = in.next();
		String[] cities = provience.get(input);
		System.out.println(cities==null? "û����Ҫȥ��ʡ��.":Arrays.toString(cities));
	}

}
