package mine.thirty.CollectionAndMap.set;

import java.util.*;

public class setDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> setDemo = new HashSet<Integer>();
		while(setDemo.size()<10){
			setDemo.add((int) (Math.random()*100));
		}
		System.out.println(setDemo);
	
		outputRed();//20Ìâ		
	}
	
	public static void outputRed(){
		String[] card = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		HashSet <Integer> setDemo2 = new HashSet<Integer>();
		while(setDemo2.size()<13){
			setDemo2.add((int) (Math.random()*54+1));
		}
		Iterator<Integer> it = setDemo2.iterator();
		while(it.hasNext()){
			int a = it.next();
			if(a<=13){
				System.out.printf("ºìÌÒ %s\n", card[a-1]);
			}			
		}
	}
	
}
