package mine.thirtySix.UDPandTCP.ClientServer;
import java.io.*;
import java.net.*;

public class ServerDemo {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			//1.ʵ����ServerSocket�����ָ�������Ķ˿ںš�
			ServerSocket ss = new ServerSocket(10002);
			//2.��ȡSocket����
			Socket s = ss.accept();
			/*
			 * 3.��ȡ���ݣ���������
			 * a.��Socket�ж�������
			 * b.������תΪ��д
			 * c.�������ݷ��ؿͻ��ˣ���ʾ��
			 */
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//��Socket������д����.
			String str = null;
			while((str=br.readLine())!=null){//����
				//ת��д
				str = str.toUpperCase();
				//д��Socket����
				bw.write(str);
				bw.newLine();
				bw.flush();
				if(str.equals("OVER")){//��������
					break;
				}			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//4.�ر���Դ
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
