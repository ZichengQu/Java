package mine.thirtySix.UDPandTCP.SendsReceives;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Test1 {

	public static void main(String[] args) {
		/**
		 * ����
		 * ��дһ���������
		 * ��������Ϊ���Ͷ˺ͽ��նˣ�������ͬʱִ��
		 * ���������̣߳�һ�� �߳̿��Ʒ��Ͷˣ�һ���߳̿��ƽ��ն�
		 */
		//class a extends c, interface a extends b, c
		try {
			DatagramSocket ds1 = new DatagramSocket();//���Ͷ�
			DatagramSocket ds2 = new DatagramSocket(10000);//���ն�
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
