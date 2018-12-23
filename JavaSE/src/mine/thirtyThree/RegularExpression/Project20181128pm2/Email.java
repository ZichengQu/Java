package mine.thirtyThree.RegularExpression.Project20181128pm2;

public class Email {
	private String email;
	
	public Email(){}

	public Email(String email) {
		super();
		this.email = email;
	}
	
	public boolean isStyle(){
		boolean at = email.indexOf("@") == email.lastIndexOf("@");//只有一个@时为true
		if(!at){
			System.out.print("@只能有一个,");
			return false;
		}else if (!(email.endsWith(".com")||email.endsWith(".cn"))) {
			System.out.print("必须以.com或.cn结尾,");
			return false;
		}
		return true;
	}
	
}
