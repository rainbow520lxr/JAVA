package 文件与文件夹;
/*
 * IO函数如下：
 * 
 * 1.创建文件描述符
 * 2.文件描述符下有许多函数
 * 3.获取文件绝对路径，获取文件的字节大小，获取文件是否可读，
 * 4.创建文件，创建文件夹，文件是否存在，文件夹是否存在
 * 
 * 
 */


//导入输入输出流包
import java.io.*;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		//创建一个文件对象,打开文件描述符,这个文件描述符下许多的方法去获取文件的信息
//		File f=new File("aa.txt");
//		
//		//得到文件的路径
//		System.out.println("文件路径"+f.getAbsolutePath());
//		
//		//得到文件的大小,这里返回的字节大小
//		System.out.println("文件大小："+f.length());
//		System.out.println("是否可读:"+f.canRead());
//		
//		
//		
		//创建一个文件和创建一个文件夹
		File f=new File("bb.txt");
		
		if(!f.exists()) {
			
			//没有该文件创建一个
			//创建文件的时候会出现一定的异常
			try {
				
				//创建这个文件
				f.createNewFile();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}else {
				
				System.out.println("已有该文件了！");
	
		}
		
		
		//创建文件夹
		File dir=new File("新建文件夹");
		
		if(!dir.isDirectory()) {
			dir.mkdir();			
		}else {
			System.out.println("该文件夹已经存在！");
			
		}
		
		//列出一个文件夹下的所有文件
		
		File cat=new File("..");
		
		if(cat.isDirectory()) 
		{
		
			File list[]=cat.listFiles();
			
			for(int i=0;i<list.length;i++)
			{
				System.out.println("我的文件："+list[i].getName());
				
			}
			
			
		}
	}

}
