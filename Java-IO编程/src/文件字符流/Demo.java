/*
 * �ַ������������
 * 
 * ����������ı�ʹ���ļ��ַ�����
 * ���������ͼƬ���ֽ��ļ�ʹ���ļ��ֽ���
 * 
 * 
 */




package �ļ��ַ���;
import java.io.*;



public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�ַ�������
		FileReader fr=null;
		//�ַ������
		FileWriter fw=null;
		
		try {
			//����һ��������
			fr=new FileReader("aa.txt");
			//�������������
			fw=new FileWriter("bb.txt");
			
			//���뵽�ڴ�
			char c[]=new char[1024];
			
			
			int n=0;
			
			while((n=fr.read(c))!=-1) {
				
				
				//���ַ�ת��Ϊ�ַ���
//				String s=new String(c,0,n);
//				System.out.println(s);
				//ʹ�ã�c,0,n)�������룬�����Լ��Ŀռ�������
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
