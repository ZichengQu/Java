package mine.thirty.CollectionAndMap.summary;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(3);
		al.add(14);
		al.add(1, 666);
		al.add(22);
		al.add(666);
		al.add(25);
		System.out.println(al);
		System.out.println(al.remove(2));
		System.out.println(al.remove(3.14));
		System.out.println(al);
		Integer[] arr = new Integer[al.size()];
		al.toArray(arr);
		System.out.println(Arrays.toString(arr));
		List<Integer> a2 = Arrays.asList(arr);
		System.out.println(a2);
	}

}
