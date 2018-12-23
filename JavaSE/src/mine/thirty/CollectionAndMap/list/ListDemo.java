package mine.thirty.CollectionAndMap.list;

import java.util.Collections;
import java.util.LinkedList;

public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> listDemo = new LinkedList<Integer>();
		for(int i=0; i<10; i++){
			listDemo.add((int) (Math.random()*100));
		}
		Collections.sort(listDemo);
		System.out.println(listDemo);
	}

}
