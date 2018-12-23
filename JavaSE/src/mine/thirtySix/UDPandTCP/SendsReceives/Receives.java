package mine.thirtySix.UDPandTCP.SendsReceives;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receives implements Runnable{
	private DatagramSocket ds;

	public Receives(DatagramSocket ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void run() {
		try {		
			while(true){
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				ds.receive(dp);
				String str = new String(dp.getData(), 0, dp.getLength());
				String ip = dp.getAddress().getHostAddress();
				System.out.println(ip+": "+str);
				if(str.equals("886")){// ÷∂ØΩ· ¯
					break;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			ds.close();
		}
	}
	
	
}
