/*
 * 后台：Dao层，只定义方法指令，不问为什么，只操作，不考虑是发起的行为，改变的谁
 */

package 学生管理系统.v2_设计模式;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SqlHelper {
	
	
	//定义变量
	private String url="jdbc:mysql://localhost:3306/lxr?userUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
	private String username="root";
	private String passwd="lixin2008";
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;

	//关闭数据库资源
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
	
	//增删改
	public boolean upExcute(String sql,String[] paras) {
		
		Boolean flag=true;
		
		try {
				//1.加载驱动
				Class.forName("com.mysql.cj.jdbc.Driver");
				//2.获取连接
				conn=(Connection)DriverManager.getConnection(url,username,passwd);
				//3.创建ps
				ps=conn.prepareStatement(sql);
				//向ps中添加参数
				for(int i=0;i<paras.length;i++) {
					ps.setString(i+1, paras[i]);
				}
				//rs是一个指针指向第一行，在java语言中rs.next()自动指针移动
				int rs=ps.executeUpdate();
				if(rs==-1) {
					flag=false;
					}
			}catch (Exception e) {
				// TODO: handle exception				
				flag=false;
				e.printStackTrace();
			}finally {
				//关闭资源
				this.close();				
			}
			return flag;
	}
	
	//查询
	public ResultSet queryExcute(String sql, String[] paras) {

		try {
			//1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.获取连接
			conn=(Connection)DriverManager.getConnection(url,username,passwd);
			//3.创建ps
			ps=conn.prepareStatement(sql);
			
			//向ps中添加参数
			if(paras!=null) {
				for(int i=0;i<paras.length;i++) {
				ps.setString(i+1, paras[i]);
				}
			}
			System.out.println(ps.toString());
			
			//rs是一个指针指向第一行，在java语言中rs.next()自动指针移动
			rs=ps.executeQuery();
		
		}catch (Exception e) {
			// TODO: handle exception				
			e.printStackTrace();
		}finally {
			//还不能关闭资源？？？
							
		}
		return rs;
		
		
	}

}

	