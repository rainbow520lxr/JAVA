package ��˫���ַ���ͨ��TCP�׽��ֱ��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {

	Socket s=null;
	//����ͻ���
	public MyClient() {
		
		try {
			
			//1.������ͨ�׽��֣�����׽��־ͺ�pipe�ܵ��ر���
			//���ֻ����Բ�ͬ�˵Ľ��̵�����ܵ���һͷ��һͷд��
			s=new Socket("127.0.0.1", 4000);
			
			
			//2.�����ͻ������������
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			
			//3.�����û�������
			BufferedReader ubr=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("���ӽ����ɹ���");
			
			while(true) {
					
				
			//	System.out.println("����ˣ�"+br.readLine());
					
				//4.������Ϣ
				System.out.print("�ͻ��ˣ�");
				bw.write(ubr.readLine()+"\r\n");
				bw.flush();
		
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			
				try {
					if(s!=null)s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		
		
	}
	
	//�����ͻ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//��ʼ���ͻ���
		MyClient mc=new MyClient();
		
	}

}
