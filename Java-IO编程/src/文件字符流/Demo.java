/*
 * 字符流的输入输出
 * 
 * 当输入输出文本使用文件字符串流
 * 当输入输出图片等字节文件使用文件字节流
 * 
 * 
 */




package 文件字符流;
import java.io.*;



public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//字符输入流
		FileReader fr=null;
		//字符输出流
		FileWriter fw=null;
		
		try {
			//创建一个流对象
			fr=new FileReader("aa.txt");
			//创建输出流对象
			fw=new FileWriter("bb.txt");
			
			//读入到内存
			char c[]=new char[1024];
			
			
			int n=0;
			
			while((n=fr.read(c))!=-1) {
				
				
				//将字符转换为字符串
//				String s=new String(c,0,n);
//				System.out.println(s);
				//使用（c,0,n)避免乱码，避免自己的空间分配过大
				fw.write(c, 0, n);
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		
		
		
	}

}
