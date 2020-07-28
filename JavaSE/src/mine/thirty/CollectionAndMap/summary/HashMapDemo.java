package mine.thirty.CollectionAndMap.summary;

import java.util.*;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String,String> map = new HashMap<String,String>();
		System.out.println(map.put("ÁÉÄş",null));
		System.out.println(map.put("¼ªÁÖ","³¤´º"));
		System.out.println(map.remove("ÁÉÄş"));
		System.out.println(map);
		System.out.println(map.keySet());
	}

}
