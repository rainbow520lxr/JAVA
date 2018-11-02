/*
 * 从数据库读入数据
 * 目前JDBC有两种驱动一个是cj.dricver一个是driver
 * 这两个驱动是有时区之差的
 * 
 */


package 学生管理系统;

import java.awt.*;
import java.util.Vector;
import java.sql.*;
import javax.swing.*;

public class ManagerSystem extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//定义组件
	JPanel jp1,jp2,jp3;
	JLabel jl;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4;
	//定义一个表
	JTable jt;
	JScrollPane jsp;
	
	//定义变量
	Vector rowData,columnName;
	String url="jdbc:mysql://localhost:3306/lxr?userUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
	String username="root";
	String password="lixin2008";
	//定义sql语句
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	public ManagerSystem() {
		
		//设置整体布局
		this.setLayout(new BorderLayout());
	
		
		//初始化组件
		jp1=new JPanel();
		jl=new JLabel("请输入名字：");
		jtf=new JTextField(22);
		jb1=new JButton("查询");
		this.add(jp1,BorderLayout.NORTH	);
		jp1.setLayout(new FlowLayout());
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		
		
		jp2=new JPanel();
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
			conn=(Connection)DriverManager.getConnection(url,username,password);
			ps=conn.prepareStatement("select * from stu");
			//rs是一个指针指向第一行，在java语言中rs.next()自动指针移动
			rs=ps.executeQuery();
			
			while(rs.next()) {				
				//rowData可以存放多行
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
		
		
		jt=new JTable(rowData,columnName);
		jsp=new JScrollPane(jt);
		this.add(jp2,BorderLayout.CENTER);
		//把jsp放入在jframe
		jp2.add(jsp);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		

		jp3=new JPanel();
		jb2=new JButton("增加");
		jb3=new JButton("删除");
		jb4=new JButton("修改");
		this.add(jp3,BorderLayout.SOUTH);
		jp3.setLayout(new FlowLayout());
		jp3.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);
		
		//窗口
		this.setLocation(300, 400);
		this.setSize(800, 600);
		this.setTitle("学生管理系统");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManagerSystem ms=new ManagerSystem();
		
		
	}

}
