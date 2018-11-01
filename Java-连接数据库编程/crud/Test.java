package crud;

import java.sql.*;
import com.mysql.cj.exceptions.*;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建连接
		Connection conn=null;
		String sql=null;
		String url="jdbc:mysql://localhost:3306/lxr?userUnicode=true&characterEncoding=UTF-8&serverTimeZone=UTC";
		String username="root";
		String password="lixin2008";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySQL驱动程序");
			conn=DriverManager.getConnection(url,username,password);
			if(conn!=null) {
				System.out.println("conn不为u空！");
			}
			
			Statement st=conn.createStatement();
			sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
			int result = st.executeUpdate(sql);
			
			if (result!=-1) {
				System.out.println("更新成功个！");
				
							}
			}catch (SQLException e) {
				// TODO: handle exception
				System.out.println("SQL操作错误！");
				e.printStackTrace();
			} catch (Exception e) {
			// TODO: handle exception
				System.out.println("系统错误！");
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
