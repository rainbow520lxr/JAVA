/*
 * 图片拷贝
 * 图片的拷贝是字节输入输出
 * 可见使用流的方式读写的是字节
 * 
 */


package 图片拷贝;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//先把图片读入到内存  写入到某个文件
		//因为图片是二进制文件，因此只能用 字节流完成
		
		//先声明
		//创建文件对象获取描述符
		File a=new File("a/pic.jpg");
		File b=new File("b/pic.jpg");
		//输入流
		FileInputStream fis=null;
		//输出流
		FileOutputStream fos=null;
		
		
		//但文件描述符没有读写能力，所以需要InputStream流
		try {
			
			fis=new FileInputStream(a);
			fos=new FileOutputStream(b);
			
			
			//定义一个字节数组,(做一个缓存)，一次只读一个字节
			byte bytes[]=new byte[1024];
			
			int n=0;//得打实际读取到得字节总数或者说位置
			
			//循环读取，此处不用循环语句，当再度自动跳到未读的字节
			while((n=fis.read(bytes))!=-1)
			{
				
				//读到的是字节再将字节输出			
				fos.write(bytes);
				
			}
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				
				//关闭输入流和输出流
				fis.close();
				fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
		
		
		
		
		
	}

}
