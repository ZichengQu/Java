package mine.thirtySix.UDPandTCP;


import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * ip������ط���
 * @author quzic
 */
public class InetAddressDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress id = null;	
		try {
			id = InetAddress.getLocalHost();//���ر��������ĵ�ַ��
			System.out.println(id);
			System.out.println("�������ƣ�"+id.getHostName());//����������ƣ�return String
			System.out.println("ip��ַ��"+id.getHostAddress());//���ip��ַ�� return String
			System.out.println(InetAddress.getByName(id.getHostName()));//ͨ�����ֻ���������� return InetAddress
			System.out.println(id.equals(InetAddress.getByName(id.getHostName())));//true
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
