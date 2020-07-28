package mine.twentyEight.caipiao2;

import java.util.Scanner;
import java.util.TreeSet;

public class Caipiao {
	/**
	 * 随机生成集合，用于中奖号码和机选。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public TreeSet<Integer> createSet(){
		TreeSet<Integer> set = new TreeSet<Integer>();
		while(set.size()<7){
			set.add((int) (Math.random()*35+1));
		}
		return set;
	}
	
	public TreeSet<Integer> handSet(Scanner sc){		
		TreeSet<Integer> set = new TreeSet<Integer>();
		while(set.size()<7){//集合长度小于7，添加数据			
			System.out.print("请输入1~35之间的数字：");
			int num = sc.nextInt();
			if(num>=1&&num<=35){
				set.add(num);
			}else{
				System.out.println("数字超出范围。");
			}			
		}
		return set;
	}
	
	public void change(TreeSet<Integer> set){
		TreeSet<String> strSet = new TreeSet<String>();
		StringBuffer sb = new StringBuffer();
		for(Integer it:set){
			if(it<=9){
				strSet.add(sb.append("0"+it).toString());
			}else{
				strSet.add(sb.append(it).toString());
			}		
		}
		for(String s: strSet){
			System.out.println(s+" ");
		}
	}
	
	public void yesOrNo(TreeSet<Integer> reSet, TreeSet<Integer> set){
		Integer[] a = new Integer[7];
		Integer[] a1 = reSet.toArray(a);
		Integer[] b = new Integer[7];
		Integer[] b1 = reSet.toArray(b);
		int count=0;
		for(int i=0;i<a.length;i++){
			if(a1[i]==b1[i]){
				count++;
			}
		}
		
	}
}
