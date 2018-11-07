package 半双工字符流通信TCP套接字编程;

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
	//为提高并发性不能在外面定义
	Socket s=null;
	
	//构造服务端
	public MyServer(){
		
		
		try {
			
			//1.建立监听套接字
			ss=new ServerSocket(4000);
			System.out.println("服务器等待连接中...");
			//2.不断等待客户发出请求
			while(true) {
				
				//3.创建一个连接套机子去接收，若没有则为空，提高并发性
				s=ss.accept();
				//3.收到连接
				if(s!=null) {
					
					System.out.println("连接收到:"+s.getInetAddress()+":"+s.getPort()+",连接成功！");			
					
					//4.建立服务端输入输出流
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
					
					//5.建立用户输出输入流
					BufferedReader ubr=new BufferedReader(new InputStreamReader(System.in));
					
			
					while(true) {
						
						//	System.out.print("服务端：");
						//	bw.write(ubr.readLine()+"\r\n");
						//	bw.flush();
							
							//while(br.readLine()==null);
							System.out.println("客户端："+br.readLine());
							
						
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
	
	//启动初始化服务端
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//初始化客户端
		MyServer ms=new MyServer();
		
	}

}
