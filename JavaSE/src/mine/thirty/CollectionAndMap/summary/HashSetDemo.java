package mine.thirty.CollectionAndMap.summary;

import java.util.*;

public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<Integer>();
		System.out.println(set.add(55));
		System.out.println(set.add(77));
		System.out.println(set.add(88));
		System.out.println(set.add(66));
		for(Integer i:set){
			System.out.println(i);
		}
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
	}

}
