package mine.thirtyTwo.carRentSystem;
import java.awt.Menu;
import java.util.*;

public class ProjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Vehicle> list = createVehicle();
		Vehicle v; //�û�ѡ��ľ��嵽��һ���ĳ�
		
		System.out.println("***********��ӭ�����ڷ��������޹�˾***********");
		System.out.printf("1���γ�\t2���ͳ�\t3������\n");
		System.out.print("��ѡ����Ҫ���޵���������: ");
		Scanner in = new Scanner(System.in);
		switch (in.nextInt()) {
		case 1:
			System.out.print("��ѡ����Ҫ���޵�����Ʒ�ƣ�1������ 2�����: ");
			v = (Car)carMenu(in.nextInt(), list);
			System.out.println("����Ҫ֧�������޷����ǣ�"+totalMoney(v));
			break;
		case 2:
			System.out.print("��ѡ����Ҫ���޵�����Ʒ�ƣ�1������ 2����: ");
			v = (Bus)busMenu(in.nextInt(), list);
			System.out.println("����Ҫ֧�������޷����ǣ�"+totalMoney(v));
			break;
		case 3:
			System.out.print("��ѡ����Ҫ���޵�����Ʒ�ƣ�1��һ����� 2���������: ");
			v = (KaChe)kaCheMenu(in.nextInt(), list);
			System.out.println("����Ҫ֧�������޷����ǣ�"+totalMoney(v));
			break;
		default:
			break;
		}
	}
	
	public static ArrayList<Vehicle> createVehicle(){
		
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		list.add(new Car("����","��NY28588",800,"X6"));
		list.add(new Car("����","��CNY3284",600,"550i"));
		list.add(new Car("���","��NT37465",300,"������"));
		list.add(new Car("���","��NT96968",600,"GL8"));
		list.add(new Bus("��","��6566754",800,16));
		list.add(new Bus("����","��8696997",800,16));
		list.add(new Bus("��","��9696996",1500,34));
		list.add(new Bus("����","��8696998",1500,34));
		list.add(new KaChe("һ�����", "��11111", 50, 1));
		list.add(new KaChe("�������", "��MH98725", 100, 1));
		list.add(new KaChe("һ�����", "��22222", 50, 2));		
		list.add(new KaChe("�������", "��MH33333", 100, 2));
		
		return list;
	}
	
	public static Vehicle carMenu(int i, ArrayList<Vehicle> list){
		if(i==1){
			System.out.print("��ѡ����Ҫ���޵������ͺţ�1��X6 2��550i");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			if(choice==1){
				return list.get(0);
			}
			if(choice==2){
				return list.get(1);
			}			
		}else if(i==2){
			System.out.print("��ѡ����Ҫ���޵������ͺţ�1�������� 2��GL8");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			if(choice==1){
				return list.get(2);
			}
			if(choice==2){
				return list.get(3);
			}
		}
		return null;		
	}

	public static Vehicle busMenu(int i, ArrayList<Vehicle> list){
		if(i==1){
			System.out.print("��ѡ����Ҫ���޵�������λ��1��16�� 2��34��");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			if(choice==1){
				return list.get(5);
			}
			if(choice==2){
				return list.get(7);
			}			
		}else if(i == 2){
			System.out.print("��ѡ����Ҫ���޵�������λ��1��16�� 2��34��");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			if(choice==1){
				return list.get(4);
			}
			if(choice==2){
				return list.get(6);
			}
		}
		return null;		
	}

	public static Vehicle kaCheMenu(int i, ArrayList<Vehicle> list){
		if(i==1){
			System.out.print("��ѡ����Ҫ���޵�������λ��1��1t 2��2t");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			if(choice==1){
				return list.get(8);
			}
			if(choice==2){
				return list.get(10);
			}			
		}else if(i==2){
			System.out.print("��ѡ����Ҫ���޵������ͺţ�1��1t 2��2t");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			if(choice==1){
				return list.get(9);
			}
			if(choice==2){
				return list.get(11);
			}
		}
		return null;		
	}

	public static double totalMoney(Vehicle v){
		System.out.print("��������Ҫ���޵�����Ϊ��");
		Scanner in = new Scanner(System.in);
		v.setDayAmount(in.nextInt());
		System.out.println("��������������ƺ��ǣ�"+v.getNumber());
		return v.discount();	
	}
}
