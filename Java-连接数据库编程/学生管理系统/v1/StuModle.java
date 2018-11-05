/*
 * 建造表模型1
 * Abstract这个能够此抽象类提供默认实现大部分的方法TableModel接口。 它负责管理听众，并提供了一些方便生成TableModelEvents并将其发送给听众。 要创建一个具体TableModel作为一个子类AbstractTableModel你只需要对以下三个方法的实现： 
  public int getRowCount();
  public int getColumnCount();
  public Object getValueAt(int row, int column); 
 * 
 * 
 */

package 学生管理系统.v1;


import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.Vector;


public class StuModle extends AbstractTableModel{


	//定义变量
	private String url="jdbc:mysql://localhost:3306/lxr?userUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
	private String username="root";
	private String passwd="lixin2008";
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private Vector columnName,rowData; 
	
	
	
	
	//多态性,构造函数
	//构造函数1,传递sql语句处理，精确查询处理
	public StuModle(String sql) {
		
		this.init(sql);
		
	}
	//构造函数2，实现列表的初始化显示
	public StuModle() {
		
		this.init("");
		
	}
	
	
	//根据sql语句,添加删除修改
	public Boolean newStu(String sql) {
		Boolean flag=true;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=(Connection)DriverManager.getConnection(url,username,passwd);
			ps=conn.prepareStatement(sql);
				
			//rs是一个指针指向第一行，在java语言中rs.next()自动指针移动
			int rs=ps.executeUpdate();
			if(rs!=-1) {
				System.out.println("操作成功!");
				flag=false;
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				
				flag=false;
				
				
			}finally {
				 
				try {
					if(conn!=null)conn.close();
					if(ps!=null) {ps.close();}
					if(rs!=null) {rs.close();}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					
				}
				
			}
	
		return flag;
	}
	
	public void delStu() {
		
		
		
	}
	
	public void changeStu() {
		
		
	}
	
	
	//初始化执行sql语句,解决冗余代码
 	public void init(String sql) {
		
		if(sql.contentEquals("")) {
			
			sql="select * from stu";
		}
		
		
		columnName=new Vector();
		//设置列名
		columnName.add("学号");
		columnName.add("姓名");
		columnName.add("性别");
		columnName.add("年龄");
		columnName.add("籍贯");
		columnName.add("系别");
		//添加行
		rowData=new Vector();
//		//创建一个行向量
//		Vector hang=new Vector();
//		hang.add("001");
//		hang.add("孙悟空");
//		hang.add("猴");
//		hang.add("10000");
//		hang.add("花果山");
//		hang.add("无门无派");
//		//将这行数据加入到rowData中
//		rowData.add(hang);
		//初始化这个jtable
		//加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=(Connection)DriverManager.getConnection(url,username,passwd);
			ps=conn.prepareStatement(sql);
			//rs是一个指针指向第一行，在java语言中rs.next()自动指针移动
			rs=ps.executeQuery();
			
			while(rs.next()) {				
				//rowData可以存放多行
				//定义一个向量来装每行的行数据
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getInt(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				//将行添加进去
				rowData.add(hang);				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			try {	
				if(conn!=null) {conn.close();}
				if(ps!=null) {ps.close();}
				if(rs!=null) {rs.close();}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		
		
	}
	
	
	//实现了tablemodel的接口的方法,而且是在创建对象的时候自动实现该方法与，构造函数很像
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnName.size();
	}

	@Override
	//得到某行某列的数据
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		//先要拿到行向量，再在行向量中拿到其中一个列数据，需要强转
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}

	//得到列名
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		//需要强转
		return (String) this.columnName.get(column);
	}
	
	
}
