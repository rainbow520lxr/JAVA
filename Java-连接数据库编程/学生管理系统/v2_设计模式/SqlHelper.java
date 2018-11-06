/*
 * ��̨��Dao�㣬ֻ���巽��ָ�����Ϊʲô��ֻ�������������Ƿ������Ϊ���ı��˭
 */

package ѧ������ϵͳ.v2_���ģʽ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SqlHelper {
	
	
	//�������
	private String url="jdbc:mysql://localhost:3306/lxr?userUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
	private String username="root";
	private String passwd="lixin2008";
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;

	//�ر����ݿ���Դ
	public void close() {
		
		try {
			if(conn!=null)conn.close();
			if(ps!=null) {ps.close();}
			if(rs!=null) {rs.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		
	}
	
	//��ɾ��
	public boolean upExcute(String sql,String[] paras) {
		
		Boolean flag=true;
		
		try {
				//1.��������
				Class.forName("com.mysql.cj.jdbc.Driver");
				//2.��ȡ����
				conn=(Connection)DriverManager.getConnection(url,username,passwd);
				//3.����ps
				ps=conn.prepareStatement(sql);
				//��ps����Ӳ���
				for(int i=0;i<paras.length;i++) {
					ps.setString(i+1, paras[i]);
				}
				//rs��һ��ָ��ָ���һ�У���java������rs.next()�Զ�ָ���ƶ�
				int rs=ps.executeUpdate();
				if(rs==-1) {
					flag=false;
					}
			}catch (Exception e) {
				// TODO: handle exception				
				flag=false;
				e.printStackTrace();
			}finally {
				//�ر���Դ
				this.close();				
			}
			return flag;
	}
	
	//��ѯ
	public ResultSet queryExcute(String sql, String[] paras) {

		try {
			//1.��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.��ȡ����
			conn=(Connection)DriverManager.getConnection(url,username,passwd);
			//3.����ps
			ps=conn.prepareStatement(sql);
			
			//��ps����Ӳ���
			if(paras!=null) {
				for(int i=0;i<paras.length;i++) {
				ps.setString(i+1, paras[i]);
				}
			}
			System.out.println(ps.toString());
			
			//rs��һ��ָ��ָ���һ�У���java������rs.next()�Զ�ָ���ƶ�
			rs=ps.executeQuery();
		
		}catch (Exception e) {
			// TODO: handle exception				
			e.printStackTrace();
		}finally {
			//�����ܹر���Դ������
							
		}
		return rs;
		
		
	}

}

	