package Tcpsocket_server;

import java.io.*;
import java.net.*;




public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String clientmessage;
		String servermessage;
		
		
		try {
			//�������������Է�������
			BufferedReader inserver=new BufferedReader(new InputStreamReader(System.in));
			//���������׽���
			ServerSocket conn=new ServerSocket(4399);	
			
			while(true){
				
			System.out.println("���ڵȴ�����...............");
				
			//�ȴ������������׽���
			Socket server=conn.accept();
			
			System.out.println("���ӳɹ���");
			
			//����������
			BufferedReader inclient=new BufferedReader(new InputStreamReader(server.getInputStream()));
			//���������
			DataOutputStream outserver=new DataOutputStream(server.getOutputStream());
			
			clientmessage=inclient.readLine();
			System.out.println(clientmessage);
			
			servermessage=inserver.readLine();
			outserver.writeBytes(servermessage+"\n");
			
			
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
		
		
		
		
		
}

