package mine.thirtyThree.RegularExpression.Project20181128pm3;

public class GCount {//indexOf, substring 
	private String str;

	public GCount(String str) {
		super();
		this.str = str;
	}
	
	public int gCount() {
		int beginIndex = str.indexOf('g');
		int count = 0;
		while(beginIndex>-1){
			count++;
			str = str.substring(beginIndex+1);			
			beginIndex = str.indexOf('g');
		}
		return count;
	}
}
