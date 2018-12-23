package mine.thirtySix.UDPandTCP.SendReceive;

import java.io.*;
import java.net.*;

public class Receive {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			//1.实例化DatagramSocket对象建立udpsocket。
			ds = new DatagramSocket(10000);			
			while(true){
				//2.创建byte数组，存放接收到的数据。			
				byte[] buf = new byte[1024];
				//2.DatagramPacket 数据包，接收数据包中的数据。
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				//真正的实现接收过程
				ds.receive(dp);
				//4.把数据转成字符串,三个参数：存放的数据，偏移量，一共一次拿多少。
				String str = new String(dp.getData(), 0, dp.getLength());
				//在控制台显示数据 ip：数据
				String ip = dp.getAddress().getHostAddress();
				System.out.println(ip+": "+str);
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
