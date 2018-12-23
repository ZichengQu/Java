package mine.thirtyFive.StringInteger;

public class Test {

	Integer a;
	Integer b;
	public Test(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public boolean isTrue(){
		if((a>-128 && a<127) && (b>-128 && b<127)){
			return a==b;
		}
		return a.equals(b);
	}
}
