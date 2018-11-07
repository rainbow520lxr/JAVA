package ����ͨ��TCP�׽��ֱ��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class MyServer {
	
	//��������׽��֣������׽���
	ServerSocket ss=null;
	Socket s=null;
	
	//��������
	public MyServer(){
		
		
		try {
			
			//1.���������׽���
			ss=new ServerSocket(4000);
			System.out.println("�������ȴ�������...");
			//2.���ϵȴ��ͻ���������
			while(true) {
				
				//3.�յ�����
				if((s=ss.accept())!=null) {
					System.out.println("�յ�����:"+s.getInetAddress()+":"+s.getPort()+",���ӳɹ���");
				}

				//4.����������
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String in_info=null;
				if((in_info=br.readLine())!=null) {
					System.out.println("���������յ���Ϣ��"+in_info);
				}else {
					System.out.println("����Ϣ��");
				}
				
				/*
				//5.�����
				System.out.print("������:");
				BufferedReader br_=new BufferedReader(new InputStreamReader(System.in));
				OutputStreamWriter osw=new OutputStreamWriter(s.getOutputStream());
				String out_info=null;
				while((out_info=br_.readLine())!=null) {
					osw.write(out_info);
				}
				osw.flush();
				*/
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			
				try {
					
					if(s!=null)s.close();
					if(ss!=null)ss.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}
	
	//������ʼ�������
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//��ʼ���ͻ���
		MyServer ms=new MyServer();
		
	}

}
