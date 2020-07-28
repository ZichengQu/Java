package mine.thirtySix.UDPandTCP.SendReceive;

import java.io.*;
import java.net.*;

public class Receive {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			//1.ʵ����DatagramSocket������udpsocket��
			ds = new DatagramSocket(10000);			
			while(true){
				//2.����byte���飬��Ž��յ������ݡ�			
				byte[] buf = new byte[1024];
				//2.DatagramPacket ���ݰ����������ݰ��е����ݡ�
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				//������ʵ�ֽ��չ���
				ds.receive(dp);
				//4.������ת���ַ���,������������ŵ����ݣ�ƫ������һ��һ���ö��١�
				String str = new String(dp.getData(), 0, dp.getLength());
				//�ڿ���̨��ʾ���� ip������
				String ip = dp.getAddress().getHostAddress();
				System.out.println(ip+": "+str);
				if(str.equals("886")){//�ֶ�����
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
