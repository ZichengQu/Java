package mine.twentyEight.caipiao2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CaiPiao2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.手选\t2.机打");
		Scanner in = new Scanner(System.in);
		int hm = in.nextInt(); //hand 或者 machine
		HashSet<Integer> choice = null;//用来存7个数的Set
		while(choice!=null){
			switch (hm) {
			case 1:
				choice = hand();
				break;
			case 2:
				choice = machine();
				break;
			default:
				break;
			}
		}
		
		System.out.println("开奖号码：");
		HashSet<Integer> prizeCode = machine();
		Object[] code = prizeCode.toArray();
		for(int i=0; i<prizeCode.size(); i++){
			System.out.printf("%02d ", code[i]);
		}
		
		System.out.println();
		
		System.out.println("已选号码：");
		Object[] choiceArray = choice.toArray();
		for(int i=0; i<choice.size(); i++){
			System.out.printf("%02d ", choiceArray[i]);
		}
		
		System.out.println();
		
		if(prizeCode.containsAll(choice)){
			System.out.println("奖金为10000元");
		}else{
			boolean flag = true;
			for(int i=0; i<choice.size(); i++){
				if(prizeCode.contains(choiceArray[i])){				
					if((int)choiceArray[i]>=0&&(int)choiceArray[i]<2){
						flag = false;
						System.out.println("很遗憾，奖励棒棒糖一个");
					}else if((int)choiceArray[i]>=2&&(int)choiceArray[i]<5){
						flag = false;
						System.out.println("奖金1000元");
					}else if((int)choiceArray[i]>=5&&(int)choiceArray[i]<7){
						flag = false;
						System.out.println("奖金5000元");
					}					
				}				
			}
			if(flag){						
				System.out.println("很遗憾，无任何奖励");
			}
		}
				
		
	}
	/**
	 * 手选
	 * @return HashSet<Integer>
	 */
	public static HashSet<Integer> hand(){
		HashSet<Integer> a = new HashSet<Integer>();
		Scanner in = new Scanner(System.in);
		while(a.size()<7){
			System.out.printf("请输入第%d个数:\n", a.size()+1);
			int number = in.nextInt();
			if(number<0||number>35){
				System.out.print("超出边界范围，请重新输入，");
				continue;
			}
			if(a.contains(number)){
				System.out.print("已重复，请重新输入，");
				continue;
			}		
			a.add(number);			
		}		
		return a;
	}
	
	/**
	 * 机选
	 * @return HashSet<Integer>
	 */
	public static HashSet<Integer> machine(){
		HashSet<Integer> a = new HashSet<Integer>();
		while(a.size()<7){
			a.add((int) (Math.random()*35+1));
		}		
		return a;
	}
}
