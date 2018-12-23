package mine.thirtyFour.StringBufferCollection;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Question8 {//1.66~68�� 2.������ʱ�����ı��������λ�û����

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		HashSet<Integer> choice = null;//������7������Set
		while(choice==null){
			System.out.println("������ѡ� 1.��ѡ\t2.����");
			int hm = in.nextInt();//hand ���� machine
			switch (hm) {
			case 1:
				choice = hand();
				break;
			case 2:
				choice = machine();
				break;
			default:
				System.out.print("�Ƿ����룬���������롣");
				break;
			}
		}
		
		System.out.println("�������룺");
		HashSet<Integer> prizeCode = machine();
		Iterator<Integer> it = prizeCode.iterator();
		while(it.hasNext()){
			System.out.printf("%02d ", it.next());
		}
		
		System.out.println();
		
		System.out.println("��ѡ���룺");
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
			System.out.println("���ź�������������һ��");
		}else if(count>=2&&count<5){
			System.out.println("����1000Ԫ");
		}else if(count>=5&&count<7){
			System.out.println("����5000Ԫ");
		}else if(count==7){
			System.out.println("����10000Ԫ");
		}	
		
	 a: while(true){
			System.out.println("�����������֤�ţ�");
			String id = in.next();
			if(identity(id)){
				while(true){
					System.out.println("��������������");
					String name = in.next();
					if(nameRegex(name)){
						System.out.println("��ϲ�ɹ���ȡ������");
						break a;
					}else{
						System.out.print("�Բ���������");
					}
				}
			}else{
				System.out.print("�Բ���������");
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
	
	public static boolean nameRegex(String name) {
		String nameStyle = "[\u4e00-\u9fa5]{2,3}";
		return name.matches(nameStyle);
	}
	
	public static boolean identity(String id) {
		String idStyle = "[1-9]\\d{5}(19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]";
		return id.matches(idStyle);
	}
}