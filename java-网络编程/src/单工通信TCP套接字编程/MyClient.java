package ����ͨ��TCP�׽��ֱ��;

import java.io.IOException;
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
			
			//2.���������,�ֽ������ת��Ϊ�ַ������
			OutputStreamWriter osw=new OutputStreamWriter(s.getOutputStream());		
			//������ӳɹ�
			//4.������Ϣ
			String out_info="�յ���Ϣ,���ǿͻ��ˣ�";
			osw.write(out_info);
			osw.flush();
			System.out.println("�ͻ��˷�������ϢΪ:"+out_info);
			
			
			/*
			//5.������
			while(true) {
				BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
				String in_info=null;
				if((in_info=br.readLine())!=null) {
					System.out.println("�������ӷ�������Ϣ��"+in_info);
				}
			}
			*/
			
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
