package mine.thirtyFour.StringBufferCollection;


import java.util.*;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> hs = new HashSet<Integer>();
		Random r = new Random();
		while (hs.size()<10) {
			hs.add(r.nextInt(100));
		}
		System.out.println(hs);
	}

}
