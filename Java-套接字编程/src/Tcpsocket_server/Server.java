package Tcpsocket_server;

import java.io.*;
import java.net.*;




public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String clientmessage;
		String servermessage;
		
		
		try {
			//创建输入流来自服务器的
			BufferedReader inserver=new BufferedReader(new InputStreamReader(System.in));
			//创建连接套接字
			ServerSocket conn=new ServerSocket(4399);	
			
			while(true){
				
			System.out.println("正在等待连接...............");
				
			//等待建立服务器套接字
			Socket server=conn.accept();
			
			System.out.println("连接成功！");
			
			//建立输入流
			BufferedReader inclient=new BufferedReader(new InputStreamReader(server.getInputStream()));
			//建立输出流
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

