/*
 * �ַ���������
 * �����ַ���
 * �ȴ����ַ��������ֽ�����Ȼ����ص������ַ����У����԰��ж����������ļ�
 *\r���ֳ���\n�����ַ�
 */

package �����ַ���_�ַ���������;

import java.io.*;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br=null;
		BufferedWriter bw=null;
				
				
		//�ȴ���Filereader
		FileReader fr=null;
		FileWriter fw=null;
		
		try {
			
			//�����ַ�������
			fr = new FileReader("aa.txt");
			//�����ַ������
			fw=new FileWriter("bb.txt");
			//���ַ����������뻺���ַ����У����ܵ����ڴ�
			br=new BufferedReader(fr);
			bw=new BufferedWriter(fw);
			
			
			//ѭ����ȡ
			String s="";
			while((s=br.readLine())!=null) {
				
				bw.write(s+"\r\n");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				
				
				//�ر��ļ�
				br.close();
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		
		
		
		
	}

}
