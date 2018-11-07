package 单工通信TCP套接字编程;

import java.io.IOException;
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
			
			//2.建立输出流,字节输出流转化为字符输出流
			OutputStreamWriter osw=new OutputStreamWriter(s.getOutputStream());		
			//如果连接成功
			//4.发送信息
			String out_info="收到消息,我是客户端！";
			osw.write(out_info);
			osw.flush();
			System.out.println("客户端发出的消息为:"+out_info);
			
			
			/*
			//5.输入流
			while(true) {
				BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
				String in_info=null;
				if((in_info=br.readLine())!=null) {
					System.out.println("服务器接发来的信息："+in_info);
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
	
	//开启客户端
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//初始化客户端
		MyClient mc=new MyClient();
		
	}

}
