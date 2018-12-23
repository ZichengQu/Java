package mine.thirtyFour.StringBufferCollection;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Question8 {//1.66~68行 2.输名字时，不改变输入光标的位置会出错。

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		HashSet<Integer> choice = null;//用来存7个数的Set
		while(choice==null){
			System.out.println("请输入选项： 1.手选\t2.机打");
			int hm = in.nextInt();//hand 或者 machine
			switch (hm) {
			case 1:
				choice = hand();
				break;
			case 2:
				choice = machine();
				break;
			default:
				System.out.print("非法输入，请重新输入。");
				break;
			}
		}
		
		System.out.println("开奖号码：");
		HashSet<Integer> prizeCode = machine();
		Iterator<Integer> it = prizeCode.iterator();
		while(it.hasNext()){
			System.out.printf("%02d ", it.next());
		}
		
		System.out.println();
		
		System.out.println("已选号码：");
		it = choice.iterator();
		while(it.hasNext()){
			System.out.printf("%02d ", it.next());
		}
		
		System.out.println();
				
		it = choice.iterator();
		int count = 0;
		while(it.hasNext()){
			if(prizeCode.contains(it.next())){
				count++;
			}
		}
		if(count>=0&&count<2){
			System.out.println("很遗憾，奖励棒棒糖一个");
		}else if(count>=2&&count<5){
			System.out.println("奖金1000元");
		}else if(count>=5&&count<7){
			System.out.println("奖金5000元");
		}else if(count==7){
			System.out.println("奖金10000元");
		}	
		
	 a: while(true){
			System.out.println("输入您的身份证号：");
			String id = in.next();
			if(identity(id)){
				while(true){
					System.out.println("输入您的姓名：");
					String name = in.next();
					if(nameRegex(name)){
						System.out.println("恭喜成功领取奖励！");
						break a;
					}else{
						System.out.print("对不起，请重新");
					}
				}
			}else{
				System.out.print("对不起，请重新");
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
	
	public static boolean nameRegex(String name) {
		String nameStyle = "[\u4e00-\u9fa5]{2,3}";
		return name.matches(nameStyle);
	}
	
	public static boolean identity(String id) {
		String idStyle = "[1-9]\\d{5}(19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]";
		return id.matches(idStyle);
	}
}