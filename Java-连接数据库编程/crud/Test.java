package crud;

import java.sql.*;
import com.mysql.cj.exceptions.*;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		Connection conn=null;
		String sql=null;
		String url="jdbc:mysql://localhost:3306/lxr?userUnicode=true&characterEncoding=UTF-8&serverTimeZone=UTC";
		String username="root";
		String password="lixin2008";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�ɹ�����MySQL��������");
			conn=DriverManager.getConnection(url,username,password);
			if(conn!=null) {
				System.out.println("conn��Ϊu�գ�");
			}
			
			Statement st=conn.createStatement();
			sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
			int result = st.executeUpdate(sql);
			
			if (result!=-1) {
				System.out.println("���³ɹ�����");
				
							}
			}catch (SQLException e) {
				// TODO: handle exception
				System.out.println("SQL��������");
				e.printStackTrace();
			} catch (Exception e) {
			// TODO: handle exception
				System.out.println("ϵͳ����");
				e.printStackTrace();
		
		
		}finally {
		
			try {
				if(conn!=null) {
				conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
}
