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
		this.ds = ds;//�����̶߳���ʱ���Զ�����udpsocket����
	}

	@Override
	public void run() {
		BufferedReader br = null;
		try {
			//��������
			br = new BufferedReader(new InputStreamReader(System.in));//���ֽ���ת�����ַ���
			String str = null;
			while((str = br.readLine())!=null){			
				byte[] buf = str.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("172.16.8.79"),10000);//���ݣ����ݳ��ȣ��������˿ںš�
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
