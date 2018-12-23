package mine.twentySeven.caipiao;

import java.util.HashSet;
import java.util.Set;

public class CaiPiao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> a = new HashSet<Integer>();
		while(a.size()<7){
			a.add((int) (Math.random()*35+1));
		}
		Integer[] b = new Integer[a.size()];
		a.toArray(b);
		for(int i=0; i<a.size(); i++){
			System.out.printf("%02d ", b[i]);
		}
	}

}
