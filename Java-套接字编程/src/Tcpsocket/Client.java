package Tcpsocket;


import java.io.IOException;
import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String addr=new String("127.0.0.1");
		
		String message;
		String modifymessage;
		
		
		//���������ֽ���,����������
		BufferedReader infromuser=new BufferedReader(new InputStreamReader(System.in));
		
		
		
		try {
			
			//�����׽���
			Socket clientsocket=new Socket(addr,4399);
			//������������������
			DataOutputStream outfromuser=new DataOutputStream(clientsocket.getOutputStream());
			//�������û���������
			BufferedReader infromserver=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
			
			
			//��ȡ�û���������
			message=infromuser.readLine();
			//���������������
			outfromuser.writeBytes(message+"\n");;
			//��ȡ����������������Ϣ
			
			
			modifymessage=infromserver.readLine();
			System.out.println("�ȴ�����������Ϣ..............");
			while(modifymessage==null) {
				modifymessage=infromserver.readLine();
			}
			System.out.println("��Ϣ�յ�Ϊ:");
			
			
			//��ӡ��Ϣ
			System.out.println(modifymessage);
			
					
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
