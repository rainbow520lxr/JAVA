/*
 * ͼƬ����
 * ͼƬ�Ŀ������ֽ��������
 * �ɼ�ʹ�����ķ�ʽ��д�����ֽ�
 * 
 */


package ͼƬ����;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�Ȱ�ͼƬ���뵽�ڴ�  д�뵽ĳ���ļ�
		//��ΪͼƬ�Ƕ������ļ������ֻ���� �ֽ������
		
		//������
		//�����ļ������ȡ������
		File a=new File("a/pic.jpg");
		File b=new File("b/pic.jpg");
		//������
		FileInputStream fis=null;
		//�����
		FileOutputStream fos=null;
		
		
		//���ļ�������û�ж�д������������ҪInputStream��
		try {
			
			fis=new FileInputStream(a);
			fos=new FileOutputStream(b);
			
			
			//����һ���ֽ�����,(��һ������)��һ��ֻ��һ���ֽ�
			byte bytes[]=new byte[1024];
			
			int n=0;//�ô�ʵ�ʶ�ȡ�����ֽ���������˵λ��
			
			//ѭ����ȡ���˴�����ѭ����䣬���ٶ��Զ�����δ�����ֽ�
			while((n=fis.read(bytes))!=-1)
			{
				
				//���������ֽ��ٽ��ֽ����			
				fos.write(bytes);
				
			}
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				
				//�ر��������������
				fis.close();
				fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
		
		
		
		
		
	}

}
