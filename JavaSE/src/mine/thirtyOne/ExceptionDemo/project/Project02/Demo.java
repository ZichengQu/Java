package mine.thirtyOne.ExceptionDemo.project.Project02;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Myself m = new Myself();
		try {
			m.shang(5,5);
		} catch (NotZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
