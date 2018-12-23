package mine.thirtySix.UDPandTCP.SendsReceives;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Test1 {

	public static void main(String[] args) {
		/**
		 * 需求：
		 * 编写一个聊天软件
		 * 分析：分为发送端和接收端，两部分同时执行
		 * 方案：多线程，一个 线程控制发送端，一个线程控制接收端
		 */
		//class a extends c, interface a extends b, c
		try {
			DatagramSocket ds1 = new DatagramSocket();//发送端
			DatagramSocket ds2 = new DatagramSocket(10000);//接收端
			Runnable r1 = new Sends(ds1);
			Runnable r2 = new Receives(ds2);
			Thread t1 = new Thread(r1);
			Thread t2 = new Thread(r2);
			t1.start();
			t2.start();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
	}

}
