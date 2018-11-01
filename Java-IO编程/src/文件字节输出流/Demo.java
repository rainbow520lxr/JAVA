/*
 * 换行符\r\n转义字符
 * 
 * 
 */

package 文件字节输出流;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileOutputStream fos=null;
		File f=new File("bb.txt");
		String s="你好，这是输入流!\r\n";
		String a="你好，这是输入流!";
		
		
		try {
			//创建输出流
			
			fos=new FileOutputStream(f);
			//一般输入时信息量都比较少，不需要建立缓存机制
			fos.write(s.getBytes());
			fos.write(a.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		}
		
	}

}
