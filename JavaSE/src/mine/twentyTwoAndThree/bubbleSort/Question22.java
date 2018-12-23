package mine.twentyTwoAndThree.bubbleSort;

import java.util.Arrays;

public class Question22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "52 -5 02 11 99 -100";
		String[]str2 = str.split(" ");
		int[] a = new int[str2.length];
		for(int k=0; k<str2.length; k++){
			a[k] = Integer.parseInt(str2[k]);
		}
				
		for(int i=0; i<a.length-1; i++){ //√∞≈›			
			for(int j=0; j<a.length-1-i; j++){
				if(a[j]>a[j+1]){
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;						
				}
			}
		}
		//Arrays.sort(a); //∆’Õ®
		
		StringBuffer str3 = new StringBuffer("");
		for(int m=0; m<str2.length; m++){
			str3.append(a[m]+" ");		
		}				
		//System.out.println(Arrays.toString(a));	
		System.out.println(str3);
	}	
}
