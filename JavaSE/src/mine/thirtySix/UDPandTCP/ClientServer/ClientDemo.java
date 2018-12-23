package mine.thirtySix.UDPandTCP.ClientServer;
import java.io.*;
import java.net.*;

public class ClientDemo {

	public static void main(String[] args) {
		System.out.println("开始：");
		Socket s = null;//Socket使用TCP连接，而DatagramSocket使用UDP连接。
		BufferedReader br1 = null;
		BufferedWriter bw = null;
		BufferedReader br2 = null;
		try {
			//1.实例化Socket类对象，指定主机和端口号
			s = new Socket(InetAddress.getLocalHost().getHostName(),10002);//s = new Socket(InetAddress.getLocalHost(),10002);//也可以
			//2.发送数据：控制台数据解读，写入Socket对象（控制台数据解读（输入），将解读的数据写入Socket对象中（输出））
			br1 = new BufferedReader(new InputStreamReader(System.in));//获取控制台数据

//			OutputStream os = s.getOutputStream();
//			OutputStreamWriter osw = new OutputStreamWriter(os); //字节输出流
//			BufferedWriter bw = new BufferedWriter(osw); //字符输出流
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//向Socket对象中写数据.				
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));//将服务端的大写结果，从Socket对象中读出，并显示在控制台。
			String str = null;
			while((str = br1.readLine())!=null){
				
				bw.write(str);//从客户端写入的数据
				bw.newLine();
				bw.flush();
				
				String res = br2.readLine();//Socket对象输入流中的大写数据，从服务器返回的大写数据
				System.out.println(res);
				
				if(str.equals("over")){//结束程序
					break;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {//3.关闭资源。
			try {
				s.close();
				br1.close();
				bw.close();
				br2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

}
