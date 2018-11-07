/*
 * 
 * ��ѭ���Ŀ�ʼ������ָ��һ���ȷ�����
 * 
 * 
 */

package �����ַ���ͨ��TCP�׽��ֱ��;

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
	//Ϊ��߲����Բ��������涨��
	Socket s=null;
	
	//��������
	public MyServer(){
		
		
		try {
			
			//1.���������׽���
			ss=new ServerSocket(4000);
			System.out.println("�������ȴ�������...");
			//2.���ϵȴ��ͻ���������
			while(true) {
				
				//3.����һ�������׻���ȥ���գ���û����Ϊ�գ���߲�����
				s=ss.accept();
				//3.�յ�����
				if(s!=null) {
					
					System.out.println("�����յ�:"+s.getInetAddress()+":"+s.getPort()+",���ӳɹ���");			
					
					//4.������������������
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
					
					//5.�����û����������
					BufferedReader ubr=new BufferedReader(new InputStreamReader(System.in));
					
					String out=null;
					String in=null;
					
					while(true) {
						
					
						//������Ϣ
						in=br.readLine();
						System.out.println("�ͻ��ˣ�"+in);
						
						//��������������ͨѶ
						if(in.equals("bye")) {
							System.out.println("ͨ������");
							s.close();
						}
						
						//�ظ�
						System.out.print("����ˣ�");
						out=ubr.readLine();
						bw.write(out+"\r\n");
						bw.flush();
							
						//��������������ͨѶ
						if(out.equals("bye")) {
							System.out.println("ͨ������");
							s.close();
						}
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			
				try {
					
		
					if(ss!=null)ss.close();
					if(s!=null)s.close();
					
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
