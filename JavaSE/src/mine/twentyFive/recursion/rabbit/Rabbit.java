package mine.twentyFive.recursion.rabbit;

public class Rabbit {
	private static int month = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(tuZi(5));
	}
	public static int tuZi(int month){
		if(month==1 || month==2){
			return 1;
		}else{
			return tuZi(month-2)+tuZi(month-1);
		}
	}

}
//1£¬1£¬2£¬ 3£¬5