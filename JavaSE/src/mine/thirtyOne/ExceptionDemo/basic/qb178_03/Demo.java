package mine.thirtyOne.ExceptionDemo.basic.qb178_03;

import java.io.*;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null;
		try {
			fr = new FileReader("d:\\aa.docx");
			int len = 0;
			while((len=fr.read())!=-1){
				System.out.print((char)len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fr!=null){
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("³É¹¦");
		}
	}

}
