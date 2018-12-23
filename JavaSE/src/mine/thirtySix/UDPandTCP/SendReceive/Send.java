package mine.thirtySix.UDPandTCP.SendReceive;

import java.io.*;
import java.net.*;

public class Send {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			//1.创建一个DatagramSocket对象，此类表示用于发送和接收数据报数据包的套接字。
			ds = new DatagramSocket();
			//2.使用字符数组接受控制台录入的数据。System.in(控制台录入),System.out(控制台输出)
			/*InputStreamReader isr = new InputStreamReader(System.in);//将控制台输入的字节转换成字符。
			BufferedReader br = new BufferedReader(isr);*/
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//3.解读控制台上录入的内容
			String str = null;
			while((str = br.readLine())!=null){			
				//4.打包数据
				byte[] buf = str.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("172.16.8.79"),10000);//数据，数据长度，主机，端口号。
				//5.实现发送
				ds.send(dp);
				if(str.equals("886")){//手动结束
					break;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			ds.close();
		}
	}

}
