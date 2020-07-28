package mine.thirtyFour.StringBufferCollection;


import java.util.*;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] card = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		HashSet <Integer> hs = new HashSet<Integer>();
		Random r = new Random();
		while(hs.size()<13){
			hs.add(r.nextInt(54)+1);
		}
		Iterator<Integer> it = hs.iterator();
		while(it.hasNext()){
			int a = it.next();
			if(a<=13){
				System.out.printf("ºìÌÒ %s\n", card[a-1]);
			}			
		}
	}

}
