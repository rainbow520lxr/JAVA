/*
 * 输入流类->文件输入流类   的使用（输入流是以字节二进制文件的方式来读取）
 * 操作对象是从内存中读取
 * 打开文件，必须关闭文件
 * 在外定义，在内创建
 * 
 */


package 文件字节输入流;

import java.io.*;


public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建文件对象获取描述符
		File f=new File("aa.txt");
		//打开文件
		FileInputStream fis=null;
		
		//但文件描述符没有读写能力，所以需要InputStream流
		try {
			
			fis=new FileInputStream(f);
			
			//定义一个字节数组,(做一个缓存)，一次只读一个字节
			byte bytes[]=new byte[1024];
			
			int n=0;//得打实际读取到得字节数
			
		
			//循环读取，此处不用循环语句，当再度自动跳到未读的字节
			while(fis.read(bytes)!=-1)  
			{
				//读到的是字节要把字节转成字符				
				String s=new String(bytes,0,n);
				System.out.println("字节计数:"+n);
				System.out.println(s);
				
			}
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				
				//关闭文件
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
