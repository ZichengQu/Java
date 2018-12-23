package mine.thirtySix.UDPandTCP.ClientServer;
import java.io.*;
import java.net.*;

public class ServerDemo {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			//1.实例化ServerSocket类对象，指定监听的端口号。
			ServerSocket ss = new ServerSocket(10002);
			//2.获取Socket对象
			Socket s = ss.accept();
			/*
			 * 3.获取数据，处理数据
			 * a.从Socket中读出数据
			 * b.把数据转为大写
			 * c.并将数据返回客户端（显示）
			 */
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//向Socket对象中写数据.
			String str = null;
			while((str=br.readLine())!=null){//读出
				//转大写
				str = str.toUpperCase();
				//写回Socket对象
				bw.write(str);
				bw.newLine();
				bw.flush();
				if(str.equals("OVER")){//结束程序
					break;
				}			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//4.关闭资源
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
