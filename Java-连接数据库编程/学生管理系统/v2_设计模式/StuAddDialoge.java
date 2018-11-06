/*
 * 
 * 自定义对话框
 * 
 */

package 学生管理系统.v2_设计模式;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StuAddDialoge extends JDialog implements ActionListener{

	
	
	//定义变量
	private String stuId,stuName,stuSex,stuJg,stuDept;
	private int stuAge;
	
	
	//定义组件
	private JLabel jl[]=new JLabel[6];
	private JButton jb1,jb2;
	private JTextField jtf[]=new JTextField[6];
	private JPanel jp[]=new JPanel[8];

	
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

	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb1) {
		//	INSERT INTO `lxr`.`stu` (`stuId`, `stuName`, `stuSex`, `stuAge`, `stuJg`, `stuDept`) VALUES ('09', '李小源', '女', '23', '四川巴中', '人系');
			
			stuId=jtf[0].getText();
			stuName=jtf[1].getText();
			stuSex=jtf[2].getText();
			stuAge=Integer.parseInt(jtf[3].getText());
			stuJg=jtf[4].getText();
			stuDept=jtf[5].getText();
			
			System.out.println(stuAge);
			System.out.println(stuSex);
			//写规则约束
			Boolean ys1=(stuId!=null&&stuId.length()==2);
			Boolean ys2=(stuName!=null);
			Boolean ys3=(stuSex.equals("男")|stuSex.equals("女")|stuSex.equals(""));
			Boolean ys4=(stuAge<100|stuAge>0|jtf[3].getText()=="");
			
			if(ys1) {System.out.println("1");}
			if(ys2) {System.out.println("2");}
			if(ys3) {System.out.println("3");}
			if(ys4) {System.out.println("4");}
			
			if(ys1&&ys2&&ys3&ys4) {
				System.out.println("执行操作");
			String sql="INSERT INTO `lxr`.`stu` (`stuId`, `stuName`, `stuSex`, `stuAge`, `stuJg`, `stuDept`) VALUES ('"+stuId+"', '"+stuName+"', '"+stuSex+"', '"+stuAge+"', '"+stuJg+"', '"+stuDept+"')";
			System.out.println(sql);
			StuModle sm=new StuModle();
			if(!sm.newStu(sql)) {
				
				//提示
				JOptionPane.showMessageDialog(this, "添加失败！");
				
			}else if(sm.newStu(sql)) {
				
				JOptionPane.showMessageDialog(this, "添加成功！");
				
			}
			
			
			//关闭对话框
			this.dispose();
			}
			
			
		}else if(e.getSource()==jb2) {
			
			//关闭对话框
			this.dispose();
			
		}
		
		
	}

	
}
