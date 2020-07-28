package mine.thirtySix.UDPandTCP.SendReceive;

import java.io.*;
import java.net.*;

public class Send {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			//1.����һ��DatagramSocket���󣬴����ʾ���ڷ��ͺͽ������ݱ����ݰ����׽��֡�
			ds = new DatagramSocket();
			//2.ʹ���ַ�������ܿ���̨¼������ݡ�System.in(����̨¼��),System.out(����̨���)
			/*InputStreamReader isr = new InputStreamReader(System.in);//������̨������ֽ�ת�����ַ���
			BufferedReader br = new BufferedReader(isr);*/
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//3.�������̨��¼�������
			String str = null;
			while((str = br.readLine())!=null){			
				//4.�������
				byte[] buf = str.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("172.16.8.79"),10000);//���ݣ����ݳ��ȣ��������˿ںš�
				//5.ʵ�ַ���
				ds.send(dp);
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
