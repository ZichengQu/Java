package mine.thirtyThree.RegularExpression.Project20181128pm2;

public class Email {
	private String email;
	
	public Email(){}

	public Email(String email) {
		super();
		this.email = email;
	}
	
	public boolean isStyle(){
		boolean at = email.indexOf("@") == email.lastIndexOf("@");//ֻ��һ��@ʱΪtrue
		if(!at){
			System.out.print("@ֻ����һ��,");
			return false;
		}else if (!(email.endsWith(".com")||email.endsWith(".cn"))) {
			System.out.print("������.com��.cn��β,");
			return false;
		}
		return true;
	}
	
}
