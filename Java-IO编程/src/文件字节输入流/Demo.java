/*
 * ��������->�ļ���������   ��ʹ�ã������������ֽڶ������ļ��ķ�ʽ����ȡ��
 * ���������Ǵ��ڴ��ж�ȡ
 * ���ļ�������ر��ļ�
 * ���ⶨ�壬���ڴ���
 * 
 */


package �ļ��ֽ�������;

import java.io.*;


public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����ļ������ȡ������
		File f=new File("aa.txt");
		//���ļ�
		FileInputStream fis=null;
		
		//���ļ�������û�ж�д������������ҪInputStream��
		try {
			
			fis=new FileInputStream(f);
			
			//����һ���ֽ�����,(��һ������)��һ��ֻ��һ���ֽ�
			byte bytes[]=new byte[1024];
			
			int n=0;//�ô�ʵ�ʶ�ȡ�����ֽ���
			
		
			//ѭ����ȡ���˴�����ѭ����䣬���ٶ��Զ�����δ�����ֽ�
			while(fis.read(bytes)!=-1)  
			{
				//���������ֽ�Ҫ���ֽ�ת���ַ�				
				String s=new String(bytes,0,n);
				System.out.println("�ֽڼ���:"+n);
				System.out.println(s);
				
			}
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				
				//�ر��ļ�
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
