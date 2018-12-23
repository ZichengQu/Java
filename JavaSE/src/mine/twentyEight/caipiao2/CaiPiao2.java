package mine.twentyEight.caipiao2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CaiPiao2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.��ѡ\t2.����");
		Scanner in = new Scanner(System.in);
		int hm = in.nextInt(); //hand ���� machine
		HashSet<Integer> choice = null;//������7������Set
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
		
		System.out.println("�������룺");
		HashSet<Integer> prizeCode = machine();
		Object[] code = prizeCode.toArray();
		for(int i=0; i<prizeCode.size(); i++){
			System.out.printf("%02d ", code[i]);
		}
		
		System.out.println();
		
		System.out.println("��ѡ���룺");
		Object[] choiceArray = choice.toArray();
		for(int i=0; i<choice.size(); i++){
			System.out.printf("%02d ", choiceArray[i]);
		}
		
		System.out.println();
		
		if(prizeCode.containsAll(choice)){
			System.out.println("����Ϊ10000Ԫ");
		}else{
			boolean flag = true;
			for(int i=0; i<choice.size(); i++){
				if(prizeCode.contains(choiceArray[i])){				
					if((int)choiceArray[i]>=0&&(int)choiceArray[i]<2){
						flag = false;
						System.out.println("���ź�������������һ��");
					}else if((int)choiceArray[i]>=2&&(int)choiceArray[i]<5){
						flag = false;
						System.out.println("����1000Ԫ");
					}else if((int)choiceArray[i]>=5&&(int)choiceArray[i]<7){
						flag = false;
						System.out.println("����5000Ԫ");
					}					
				}				
			}
			if(flag){						
				System.out.println("���ź������κν���");
			}
		}
				
		
	}
	/**
	 * ��ѡ
	 * @return HashSet<Integer>
	 */
	public static HashSet<Integer> hand(){
		HashSet<Integer> a = new HashSet<Integer>();
		Scanner in = new Scanner(System.in);
		while(a.size()<7){
			System.out.printf("�������%d����:\n", a.size()+1);
			int number = in.nextInt();
			if(number<0||number>35){
				System.out.print("�����߽緶Χ�����������룬");
				continue;
			}
			if(a.contains(number)){
				System.out.print("���ظ������������룬");
				continue;
			}		
			a.add(number);			
		}		
		return a;
	}
	
	/**
	 * ��ѡ
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
