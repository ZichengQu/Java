package mine.ten.fengzhuang;

import java.util.Arrays;
import java.util.Scanner;

public class FengZhuang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,7,6,3,8,2};
		System.out.println("������һ�� ����");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		a = decreaseSort(a);
		int index = erFenChaZhao(a, number);
		System.out.println("��ͬԪ�ص��±�Ϊ(-1��������ͬԪ�أ���"+index);
		a = chaRu(a, number);
		System.out.println("������(�ѽ��򣬲����)��"+Arrays.toString(a));
		
	}

	public static int[] decreaseSort(int[] arr){			
		for(int i=0; i<arr.length-1; i++){				
			for(int j=0; j<arr.length-1-i; j++){
				if(arr[j]<arr[j+1]){
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;						
				}
			}
		}
		System.out.println("ԭ����(�����)��"+Arrays.toString(arr));
		return arr;	
	}

	public static int erFenChaZhao(int[] arr, int number){
		int min = 0;
		int max = arr.length-1;
		int mid = 0;
		
		while(min<=max){
			mid = (min+max+1)/2;
			if(number<arr[mid]){
				min = mid+1;
				//System.out.println("Test1:"+"min:"+min+"mid:"+mid+"max:"+max);
			}else if (number>arr[mid]){
				max = mid-1;
				//System.out.println("Test2:"+"min:"+min+"mid:"+mid+"max:"+max);
			}else if(number==arr[mid]){
				//System.out.println("Test3:"+"min:"+min+"mid:"+mid+"max:"+max);
				return mid;
			}		
		}				
		return -1;
	}

	public static int[] chaRu(int[] arr, int number){
		int n=0;
		for(n=0; n<arr.length; n++){
			if(number>arr[n]){
				break;
			}
		}						
		
		int[] arr2 = new int[7];
		arr2[n] = number;
		
		for(int m=0; m<n; m++){
			arr2[m] = arr[m];
			//System.out.println("1�����飺"+Arrays.toString(arr2));
		}
		
		for(int h=n+1; h<arr2.length; h++){
			arr2[h] = arr[h-1];
			//System.out.println("2�����飺"+Arrays.toString(arr2));
		}
		
		return arr2;
	}
}