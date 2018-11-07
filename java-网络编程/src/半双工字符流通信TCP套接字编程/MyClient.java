package 半双工字符流通信TCP套接字编程;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {

	Socket s=null;
	//构造客户端
	public MyClient() {
		
		try {
			
			//1.创建普通套接字，这个套接字就和pipe管道特别像，
			//这个只是面对不同端的进程的网络管道，一头读一头写。
			s=new Socket("127.0.0.1", 4000);
			
			
			//2.建立客户端输入输出流
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			
			//3.建立用户输入流
			BufferedReader ubr=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("连接建立成功！");
			
			while(true) {
					
				
			//	System.out.println("服务端："+br.readLine());
					
				//4.发送信息
				System.out.print("客户端：");
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
	
	//开启客户端
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//初始化客户端
		MyClient mc=new MyClient();
		
	}

}
