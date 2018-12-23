package mine.twentyFour.recursion.jiujiu;

public class JiuJiu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		diGui(3);
	}
	
	public static void diGui(int num){
		if(num==1){
			System.out.println("1*1=1");
		}else{
			diGui(num-1);
			//System.out.println(num);
			for(int j=1;j<=num;j++){
				System.out.print(j+"*"+num+"="+(num*j)+"\t");
			}
			System.out.println();
		}
	}

}
