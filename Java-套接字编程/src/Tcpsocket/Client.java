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
		
		
		//创建输入字节流,并读入数据
		BufferedReader infromuser=new BufferedReader(new InputStreamReader(System.in));
		
		
		
		try {
			
			//创建套接字
			Socket clientsocket=new Socket(addr,4399);
			//创建向服务器的输出流
			DataOutputStream outfromuser=new DataOutputStream(clientsocket.getOutputStream());
			//创建向用户的输入流
			BufferedReader infromserver=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
			
			
			//读取用户输入数据
			message=infromuser.readLine();
			//向输出流加载数据
			outfromuser.writeBytes(message+"\n");;
			//获取服务器所发来的消息
			
			
			modifymessage=infromserver.readLine();
			System.out.println("等待服务器的消息..............");
			while(modifymessage==null) {
				modifymessage=infromserver.readLine();
			}
			System.out.println("消息收到为:");
			
			
			//打印消息
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
