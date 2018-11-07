package 单工通信TCP套接字编程;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class MyServer {
	
	//定义监听套接字，数据套接字
	ServerSocket ss=null;
	Socket s=null;
	
	//构造服务端
	public MyServer(){
		
		
		try {
			
			//1.建立监听套接字
			ss=new ServerSocket(4000);
			System.out.println("服务器等待连接中...");
			//2.不断等待客户发出请求
			while(true) {
				
				//3.收到连接
				if((s=ss.accept())!=null) {
					System.out.println("收到连接:"+s.getInetAddress()+":"+s.getPort()+",连接成功！");
				}

				//4.建立输入流
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String in_info=null;
				if((in_info=br.readLine())!=null) {
					System.out.println("服务器接收到信息："+in_info);
				}else {
					System.out.println("无消息！");
				}
				
				/*
				//5.输出流
				System.out.print("请输入:");
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
	
	//启动初始化服务端
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//初始化客户端
		MyServer ms=new MyServer();
		
	}

}
