package mine.thirtyOne.ExceptionDemo.project.Project02;

public class Myself {
	
	public double shang(double num1, double num2) throws NotZeroException, Exception{
		if(num2==0){
			throw new NotZeroException("��������Ϊ0");
		}
		return num1/num2;
	}
}
