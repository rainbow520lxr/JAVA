/*
 *新增功能：
 *实现增删改查，对按钮绑定事件
 *对于同一个类里面可以使用e.getSource来获取监听信息，可以不用setActionCommand
 *数据库的表的操作进行封，避免在每次点击相应按键的时候要写一个jdbc连接，产生冗余代码
 *创建表模型
 *
 *
 */


package 学生管理系统.v1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.sql.*;
import javax.swing.*;

public class ManagerSystem extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//定义组件
	private JPanel jp1,jp3;
	private JLabel jl;
	private JTextField jtf;
	private JButton jb1,jb2,jb3,jb4;
	//定义一个表
	private JTable jt;
	private JScrollPane jsp;
	private StuModle sm;
	
	
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
		
		sm=new StuModle();
		jt=new JTable(sm);
		jt.getTableHeader().setResizingAllowed(false); 
		jt.getTableHeader().setReorderingAllowed(false);
		jsp=new JScrollPane(jt);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(jsp,BorderLayout.CENTER);
		//把jsp放入在jframe
		
		jp3=new JPanel();
		jb2=new JButton("添加");
		jb3=new JButton("删除");
		jb4=new JButton("修改");
		this.add(jp3,BorderLayout.SOUTH);
		jp3.setLayout(new FlowLayout());
		jp3.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);
		
		//添加事件
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		
		
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

//事件处理
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1) {
			
			System.out.println("进行查询...");
			//因为把对表的数据封装到了StuModel中，我们就可以比较简单的完成查询
			String name=this.jtf.getText().trim();//使用trim将前导和空字符删去
			//写一个查询的sql语句
			String sql="select * from stu where stuName='"+name+"'";
			//生成一个新执行了查询语句的模型表
			StuModle sm=new StuModle(sql);
			//更新加载到jtable的模型
			jt.setModel(sm);
			System.out.println(sql);
			
		}else if(e.getSource()==jb2) {
			
			StuAddDialoge sad=new StuAddDialoge(this, "添加学生", true);
			
			
			
		}
		
		
	}

}
