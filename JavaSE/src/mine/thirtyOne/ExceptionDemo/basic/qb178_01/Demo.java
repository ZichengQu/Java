package mine.thirtyOne.ExceptionDemo.basic.qb178_01;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] s = new String[2];
		try{
			System.out.println(s[3]);
			System.out.println(s[0]);
		}catch(ArrayIndexOutOfBoundsException ae){
			System.out.println("���ǵڶ�������");
		}catch(RuntimeException re){
			System.out.println("���ǵ�һ������");
		}catch(Exception e){
			System.out.println("���Ǹ���");
		}
		
		try {
			//���ܳ����쳣�Ĵ���,�κ�һ�д�������쳣��try�е����´������ִ�С�
		} catch(Exception e){//�쳣�� ������
			//�����쳣�Ĵ���
		}finally {
			// TODO: handle finally clause
			//�����Ƿ�����쳣��Ҫִ�еĴ���
		}
	}

}
