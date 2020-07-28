package mine.thirtyOne.ExceptionDemo.basic.qb178_02;

import java.io.*;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("test.txt");
		File f = new File("d:\\game");
		try {
			System.out.println(file.isDirectory());
			System.out.println(file.exists());
			System.out.println(file.delete());
			System.out.println(file.equals(f));
			System.out.println(file.createNewFile());
			System.out.println(f.getAbsolutePath());
			System.out.println(file.getAbsoluteFile());
			System.out.println(file.getName());
			System.out.println(f.mkdir());
			String[] files = f.list();
			for(String fi:files){
				System.out.println(fi);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
