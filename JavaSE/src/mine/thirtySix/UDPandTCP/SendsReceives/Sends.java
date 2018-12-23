package mine.thirtySix.UDPandTCP.SendsReceives;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Sends implements Runnable{
	private DatagramSocket ds;

	public Sends(DatagramSocket ds) {
		super();
		this.ds = ds;//创建线程对象时，自动产生udpsocket服务
	}

	@Override
	public void run() {
		BufferedReader br = null;
		try {
			//解析数据
			br = new BufferedReader(new InputStreamReader(System.in));//将字节流转换成字符流
			String str = null;
			while((str = br.readLine())!=null){			
				byte[] buf = str.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("172.16.8.79"),10000);//数据，数据长度，主机，端口号。
				ds.send(dp);
				if(str.equals("886")){
					break;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ds.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
