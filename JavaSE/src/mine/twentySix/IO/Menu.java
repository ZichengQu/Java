package mine.twentySix.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Menu { //docx不好使，txt好使

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File("src");
		File[] subs = dir.listFiles();
		for(File sub: subs){
			System.out.println(sub.getPath());
			File[] subss = sub.listFiles();
			for(File subsss: subss){
				System.out.println(subsss.getPath());
			}
		}
		
		/*
		RandomAccessFile docx = new RandomAccessFile("content.txt", "rw");
		for(File sub: subs){
			if(sub.isFile()&&sub.toString().endsWith(".txt")){
				RandomAccessFile txt = new RandomAccessFile(sub, "r");				
				byte[] buf = new byte[1024*10];
				int len = -1;
				while((len = txt.read(buf))!=-1){
					/*String str = new String(buf, 0, len, "UTF-8");
					byte[] data = str.getBytes("UTF-8");
					doc.write(data);//
					docx.write(buf, 0, len);
				}
				txt.close();								
			}
		}
		docx.close();*/
	}

}
