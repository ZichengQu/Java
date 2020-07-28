package mine.thirtySix.UDPandTCP;


import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * ip主机相关方法
 * @author quzic
 */
public class InetAddressDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress id = null;	
		try {
			id = InetAddress.getLocalHost();//返回本地主机的地址。
			System.out.println(id);
			System.out.println("主机名称："+id.getHostName());//获得主机名称，return String
			System.out.println("ip地址："+id.getHostAddress());//获得ip地址， return String
			System.out.println(InetAddress.getByName(id.getHostName()));//通过名字获得主机对象， return InetAddress
			System.out.println(id.equals(InetAddress.getByName(id.getHostName())));//true
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
