package �ļ����ļ���;
/*
 * IO�������£�
 * 
 * 1.�����ļ�������
 * 2.�ļ�������������ຯ��
 * 3.��ȡ�ļ�����·������ȡ�ļ����ֽڴ�С����ȡ�ļ��Ƿ�ɶ���
 * 4.�����ļ��������ļ��У��ļ��Ƿ���ڣ��ļ����Ƿ����
 * 
 * 
 */


//���������������
import java.io.*;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		//����һ���ļ�����,���ļ�������,����ļ������������ķ���ȥ��ȡ�ļ�����Ϣ
//		File f=new File("aa.txt");
//		
//		//�õ��ļ���·��
//		System.out.println("�ļ�·��"+f.getAbsolutePath());
//		
//		//�õ��ļ��Ĵ�С,���ﷵ�ص��ֽڴ�С
//		System.out.println("�ļ���С��"+f.length());
//		System.out.println("�Ƿ�ɶ�:"+f.canRead());
//		
//		
//		
		//����һ���ļ��ʹ���һ���ļ���
		File f=new File("bb.txt");
		
		if(!f.exists()) {
			
			//û�и��ļ�����һ��
			//�����ļ���ʱ������һ�����쳣
			try {
				
				//��������ļ�
				f.createNewFile();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}else {
				
				System.out.println("���и��ļ��ˣ�");
	
		}
		
		
		//�����ļ���
		File dir=new File("�½��ļ���");
		
		if(!dir.isDirectory()) {
			dir.mkdir();			
		}else {
			System.out.println("���ļ����Ѿ����ڣ�");
			
		}
		
		//�г�һ���ļ����µ������ļ�
		
		File cat=new File("..");
		
		if(cat.isDirectory()) 
		{
		
			File list[]=cat.listFiles();
			
			for(int i=0;i<list.length;i++)
			{
				System.out.println("�ҵ��ļ���"+list[i].getName());
				
			}
			
			
		}
	}

}
