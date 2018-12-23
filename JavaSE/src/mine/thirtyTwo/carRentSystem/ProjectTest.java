package mine.thirtyTwo.carRentSystem;
import java.awt.Menu;
import java.util.*;

public class ProjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Vehicle> list = createVehicle();
		Vehicle v; //用户选择的具体到哪一个的车
		
		System.out.println("***********欢迎光临腾飞汽车租赁公司***********");
		System.out.printf("1、轿车\t2、客车\t3、卡车\n");
		System.out.print("请选择你要租赁的汽车类型: ");
		Scanner in = new Scanner(System.in);
		switch (in.nextInt()) {
		case 1:
			System.out.print("请选择你要租赁的汽车品牌：1、宝马 2、别克: ");
			v = (Car)carMenu(in.nextInt(), list);
			System.out.println("您需要支付的租赁费用是："+totalMoney(v));
			break;
		case 2:
			System.out.print("请选择你要租赁的汽车品牌：1、金龙 2、金杯: ");
			v = (Bus)busMenu(in.nextInt(), list);
			System.out.println("您需要支付的租赁费用是："+totalMoney(v));
			break;
		case 3:
			System.out.print("请选择你要租赁的汽车品牌：1、一汽解放 2、重庆红岩: ");
			v = (KaChe)kaCheMenu(in.nextInt(), list);
			System.out.println("您需要支付的租赁费用是："+totalMoney(v));
			break;
		default:
			break;
		}
	}
	
	public static ArrayList<Vehicle> createVehicle(){
		
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		list.add(new Car("宝马","京NY28588",800,"X6"));
		list.add(new Car("宝马","京CNY3284",600,"550i"));
		list.add(new Car("别克","京NT37465",300,"林荫大道"));
		list.add(new Car("别克","京NT96968",600,"GL8"));
		list.add(new Bus("金杯","京6566754",800,16));
		list.add(new Bus("金龙","京8696997",800,16));
		list.add(new Bus("金杯","京9696996",1500,34));
		list.add(new Bus("金龙","京8696998",1500,34));
		list.add(new KaChe("一汽解放", "京11111", 50, 1));
		list.add(new KaChe("重庆红岩", "京MH98725", 100, 1));
		list.add(new KaChe("一汽解放", "京22222", 50, 2));		
		list.add(new KaChe("重庆红岩", "京MH33333", 100, 2));
		
		return list;
	}
	
	public static Vehicle carMenu(int i, ArrayList<Vehicle> list){
		if(i==1){
			System.out.print("请选择你要租赁的汽车型号：1、X6 2、550i");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			if(choice==1){
				return list.get(0);
			}
			if(choice==2){
				return list.get(1);
			}			
		}else if(i==2){
			System.out.print("请选择你要租赁的汽车型号：1、林荫大道 2、GL8");
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
			System.out.print("请选择你要租赁的汽车座位：1、16座 2、34座");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			if(choice==1){
				return list.get(5);
			}
			if(choice==2){
				return list.get(7);
			}			
		}else if(i == 2){
			System.out.print("请选择你要租赁的汽车座位：1、16座 2、34座");
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
			System.out.print("请选择你要租赁的汽车吨位：1、1t 2、2t");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			if(choice==1){
				return list.get(8);
			}
			if(choice==2){
				return list.get(10);
			}			
		}else if(i==2){
			System.out.print("请选择你要租赁的汽车型号：1、1t 2、2t");
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
		System.out.print("请输入您要租赁的天数为：");
		Scanner in = new Scanner(System.in);
		v.setDayAmount(in.nextInt());
		System.out.println("分配给您的汽车牌号是："+v.getNumber());
		return v.discount();	
	}
}
