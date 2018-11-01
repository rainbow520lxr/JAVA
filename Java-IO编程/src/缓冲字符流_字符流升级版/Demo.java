/*
 * 字符流升级版
 * 缓冲字符流
 * 先创建字符流或者字节流，然后加载到缓冲字符流中，可以按行读，读大型文件
 *\r回字车符\n换行字符
 */

package 缓冲字符流_字符流升级版;

import java.io.*;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br=null;
		BufferedWriter bw=null;
				
				
		//先创建Filereader
		FileReader fr=null;
		FileWriter fw=null;
		
		try {
			
			//创建字符输入流
			fr = new FileReader("aa.txt");
			//创建字符输出流
			fw=new FileWriter("bb.txt");
			//将字符输入流放入缓冲字符流中，接受的是内存
			br=new BufferedReader(fr);
			bw=new BufferedWriter(fw);
			
			
			//循环读取
			String s="";
			while((s=br.readLine())!=null) {
				
				bw.write(s+"\r\n");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				
				
				//关闭文件
				br.close();
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		
		
		
		
	}

}
