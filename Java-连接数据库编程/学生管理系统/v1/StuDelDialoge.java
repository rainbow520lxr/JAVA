/*
 * 
 * �Զ���Ի���
 * 
 */

package ѧ������ϵͳ.v1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StuDelDialoge extends JDialog implements ActionListener{

	
	
	//�������
	private String stuId,stuName,stuSex,stuJg,stuDept;
	private int stuAge;
	private String prestuId;
	
	
	//�������
	private JLabel jl[]=new JLabel[6];
	private JButton jb1,jb2;
	private JButton jb[]=new JButton[6];
	private JTextField jtf[]=new JTextField[6];
	private JPanel jp[]=new JPanel[8];

	
	//�Զ���Ի���
	//owner ��������
	//title �Ի�����
	//modal ָ����ģʽ���ڣ����Ƿ�ģʽ���ڣ��Ի������*ֻ���Ȳ����öԻ���*��һ������
	
	
	//��ʼ��
	public StuDelDialoge(JFrame owner, String title, boolean modal,String stu[],int column) {
		
		super(owner,title,modal);//���ø���Ĺ��췽�����ﵽģʽ�Ի�Ч��
		this.prestuId=stu[0];
		
		
		
		//��ʹ����岼��
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
		
		
		//��ʼ�����
		jl[0]=new JLabel("ѧ��");
		jl[1]=new JLabel("����");
		jl[2]=new JLabel("�Ա�");
		jl[3]=new JLabel("����");
		jl[4]=new JLabel("����");
		jl[5]=new JLabel("ϵ��");
		
		for(int i=0;i<6;i++) {
			
			
			jtf[i]=new JTextField(20);
			jtf[i].setText(stu[i]);
			if(i!=column) jtf[i].setEnabled(false);
			
			jb[i]=new JButton("...");
		}
		
		
		jb1=new JButton("�ύ");
		jb2=new JButton("ȡ��");
		
		//������	
		for(int i=0;i<6;i++) {
			jp[i].add(jl[i]);
			jp[i].add(jtf[i]);
			jp[i].add(jb[i]);
		}
	
		jp[7].add(jb1);
		jp[7].add(jb2);
		
		//����¼�
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		for(int i=0;i<6;i++) {	
			jb[i].addActionListener(this);
			jb[i].setActionCommand(Integer.toString(i));
		}
		
		//����
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
		//	INSERT INTO `lxr`.`stu` (`stuId`, `stuName`, `stuSex`, `stuAge`, `stuJg`, `stuDept`) VALUES ('09', '��СԴ', 'Ů', '23', '�Ĵ�����', '��ϵ');
			
			stuId=jtf[0].getText();
			stuName=jtf[1].getText();
			stuSex=jtf[2].getText();
			stuAge=Integer.parseInt(jtf[3].getText());
			stuJg=jtf[4].getText();
			stuDept=jtf[5].getText();
			
			
			String sql="UPDATE `lxr`.`stu` SET `stuId` = '"+stuId+"', `stuName` = '"+stuName+"', `stuSex` = '"+stuSex+"', `stuAge` = '"+stuAge+"', `stuJg` = '"+stuJg+"', `stuDept` = '"+stuDept+"' WHERE (`stuId` = '"+prestuId+"')";
					
			System.out.println(sql);
			StuModle sm=new StuModle();
			sm.newStu(sql);
			this.hide();
			
			
		}else if(e.getSource()==jb2) {
			
			this.hide();
			
		}else if(e.getSource()==jb[0]|e.getSource()==jb[1]|e.getSource()==jb[2]|e.getSource()==jb[3]|e.getSource()==jb[4]|e.getSource()==jb[5]) {
			
			Boolean flag=jtf[Integer.parseInt(e.getActionCommand())].isEnabled();
			jtf[Integer.parseInt(e.getActionCommand())].setEnabled(!flag);
			System.out.println(Integer.parseInt(e.getActionCommand()));
			
		}
		
		
	}

	
}
