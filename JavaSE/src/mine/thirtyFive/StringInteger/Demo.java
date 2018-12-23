package mine.thirtyFive.StringInteger;

public class Demo {

	public static void main(String[] args) {
		String s = "H4e5l2lo3Wol2d";//有长度，是0， return true
		String s1 = "   Hello World   ";//空对象，没长度， NullPointerException
		String s2 = "   Hello World   ";//有对象，有长度，是0，return true
		System.out.println(s.toLowerCase());
		System.out.println(s1.toUpperCase());
		String[] strings = s.split("\\w");
		for(String st:strings){
			System.out.println(st);
		}
		
//		Test t1 = new Test(126, 126);
//		Test t2 = new Test(129, 129);
//		Test t3 = new Test(127, 127);
//		System.out.println(t1.isTrue() && t2.isTrue());
//		System.out.println(t1.isTrue() && t3.isTrue());
//		System.out.println(t2.isTrue());
	}
}
