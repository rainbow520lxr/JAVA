/*
 * ���з�\r\nת���ַ�
 * 
 * 
 */

package �ļ��ֽ������;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileOutputStream fos=null;
		File f=new File("bb.txt");
		String s="��ã�����������!\r\n";
		String a="��ã�����������!";
		
		
		try {
			//���������
			
			fos=new FileOutputStream(f);
			//һ������ʱ��Ϣ�����Ƚ��٣�����Ҫ�����������
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
