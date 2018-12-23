package mine.thirtyFour.StringBufferCollection;

import java.util.*;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		for(int i=0; i<10; i++){
			list.add(r.nextInt(100));
		}
		Collections.sort(list);
		System.out.println(list);
	}

}
