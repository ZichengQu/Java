package mine.thirtySix.UDPandTCP.ClientServer;
import java.io.*;
import java.net.*;

public class ClientDemo {

	public static void main(String[] args) {
		System.out.println("��ʼ��");
		Socket s = null;//Socketʹ��TCP���ӣ���DatagramSocketʹ��UDP���ӡ�
		BufferedReader br1 = null;
		BufferedWriter bw = null;
		BufferedReader br2 = null;
		try {
			//1.ʵ����Socket�����ָ�������Ͷ˿ں�
			s = new Socket(InetAddress.getLocalHost().getHostName(),10002);//s = new Socket(InetAddress.getLocalHost(),10002);//Ҳ����
			//2.�������ݣ�����̨���ݽ����д��Socket���󣨿���̨���ݽ�������룩�������������д��Socket�����У��������
			br1 = new BufferedReader(new InputStreamReader(System.in));//��ȡ����̨����

//			OutputStream os = s.getOutputStream();
//			OutputStreamWriter osw = new OutputStreamWriter(os); //�ֽ������
//			BufferedWriter bw = new BufferedWriter(osw); //�ַ������
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//��Socket������д����.				
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));//������˵Ĵ�д�������Socket�����ж���������ʾ�ڿ���̨��
			String str = null;
			while((str = br1.readLine())!=null){
				
				bw.write(str);//�ӿͻ���д�������
				bw.newLine();
				bw.flush();
				
				String res = br2.readLine();//Socket�����������еĴ�д���ݣ��ӷ��������صĴ�д����
				System.out.println(res);
				
				if(str.equals("over")){//��������
					break;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {//3.�ر���Դ��
			try {
				s.close();
				br1.close();
				bw.close();
				br2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

}
