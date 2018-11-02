/*
 * 
 * 自定义对话框
 * 
 */

package 学生管理系统.v1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StuAddDialoge extends JDialog implements ActionListener{

	//定义组件
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	
	//自定义对话框
	//owner 父窗口名
	//title 对话框名
	//modal 指定是模式窗口，还是非模式窗口，对话框出项*只能先操作该对话框*，一个不用
	
	
	//初始化
	public StuAddDialoge(JFrame owner, String title, boolean modal) {
		
		super(owner,title,modal);//调用父类的构造方法，达到模式对话效果
		
		this.setLayout(new BorderLayout());
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		
		jl1=new JLabel("学号");
		jl2=new JLabel("姓名");
		jl3=new JLabel("性别");
		jl4=new JLabel("年龄");
		jl5=new JLabel("籍贯");
		jl6=new JLabel("系别");
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		jtf6=new JTextField();
		
		jb1=new JButton("提交");
		jb2=new JButton("取消");
		
		//添加组件
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		jp1.setLayout(new GridLayout(6,1));
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.setLayout(new GridLayout(6,1));
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//添加事件
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		
		//窗口
		this.setSize(400,300);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb1) {
			
			
			
		}else if(e.getSource()==jb2) {
			
			this.hide();
			
		}
		
		
	}

	
}
