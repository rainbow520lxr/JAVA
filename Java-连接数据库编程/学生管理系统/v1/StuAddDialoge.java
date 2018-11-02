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
	JLabel jl[]=new JLabel[6];
	JButton jb1,jb2;
	JTextField jtf[]=new JTextField[6];
	JPanel jp[]=new JPanel[8];
	
	//自定义对话框
	//owner 父窗口名
	//title 对话框名
	//modal 指定是模式窗口，还是非模式窗口，对话框出项*只能先操作该对话框*，一个不用
	
	
	//初始化
	public StuAddDialoge(JFrame owner, String title, boolean modal) {
		
		super(owner,title,modal);//调用父类的构造方法，达到模式对话效果
		
		//先使用面板布局
		this.setLayout(new BorderLayout());
		for(int i=0;i<8;i++) {
			jp[i]=new JPanel();
		}
		this.add(jp[6],BorderLayout.CENTER);
		jp[6].setLayout(new GridLayout(6,1));
		this.add(jp[7],BorderLayout.SOUTH);
		jp[7].setLayout(new FlowLayout(FlowLayout.CENTER));
		for(int i=0;i<6;i++) {
			jp[6].add(jp[i]);
			jp[i].setLayout(new FlowLayout(FlowLayout.CENTER));
		}
		
		
		//初始化组件
		jl[0]=new JLabel("学号");
		jl[1]=new JLabel("姓名");
		jl[2]=new JLabel("性别");
		jl[3]=new JLabel("年龄");
		jl[4]=new JLabel("籍贯");
		jl[5]=new JLabel("系别");
		
		for(int i=0;i<6;i++) {
			jtf[i]=new JTextField(20);
		}
	
		jb1=new JButton("提交");
		jb2=new JButton("取消");
		
		//添加组件	
		for(int i=0;i<6;i++) {
			jp[i].add(jl[i]);
			jp[i].add(jtf[i]);
		}
	
		jp[7].add(jb1);
		jp[7].add(jb2);
		
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
