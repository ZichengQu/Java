package mine.thirtyOne.ExceptionDemo.basic.qb178_01;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] s = new String[2];
		try{
			System.out.println(s[3]);
			System.out.println(s[0]);
		}catch(ArrayIndexOutOfBoundsException ae){
			System.out.println("我是第二层子类");
		}catch(RuntimeException re){
			System.out.println("我是第一层子类");
		}catch(Exception e){
			System.out.println("我是父类");
		}
		
		try {
			//可能出现异常的代码,任何一行代码出现异常，try中的余下代码均不执行。
		} catch(Exception e){//异常类 对象名
			//处理异常的代码
		}finally {
			// TODO: handle finally clause
			//无论是否出现异常都要执行的代码
		}
	}

}
