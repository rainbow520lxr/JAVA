/*
 * 
 * �Զ���Ի���
 * 
 */

package ѧ������ϵͳ.v2_���ģʽ;

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

	
	
	//�������
	private String stuId,stuName,stuSex,stuJg,stuDept;
	private int stuAge;
	
	
	//�������
	private JLabel jl[]=new JLabel[6];
	private JButton jb1,jb2;
	private JTextField jtf[]=new JTextField[6];
	private JPanel jp[]=new JPanel[8];

	
	//�Զ���Ի���
	//owner ��������
	//title �Ի�����
	//modal ָ����ģʽ���ڣ����Ƿ�ģʽ���ڣ��Ի������*ֻ���Ȳ����öԻ���*��һ������
	
	
	//��ʼ��
	public StuAddDialoge(JFrame owner, String title, boolean modal) {
		
		super(owner,title,modal);//���ø���Ĺ��췽�����ﵽģʽ�Ի�Ч��
		
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
		}
	
		jb1=new JButton("�ύ");
		jb2=new JButton("ȡ��");
		
		//������	
		for(int i=0;i<6;i++) {
			jp[i].add(jl[i]);
			jp[i].add(jtf[i]);
		}
	
		jp[7].add(jb1);
		jp[7].add(jb2);
		
		//����¼�
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		
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
			
			System.out.println(stuAge);
			System.out.println(stuSex);
			//д����Լ��
			Boolean ys1=(stuId!=null&&stuId.length()==2);
			Boolean ys2=(stuName!=null);
			Boolean ys3=(stuSex.equals("��")|stuSex.equals("Ů")|stuSex.equals(""));
			Boolean ys4=(stuAge<100|stuAge>0|jtf[3].getText()=="");
			
			if(ys1) {System.out.println("1");}
			if(ys2) {System.out.println("2");}
			if(ys3) {System.out.println("3");}
			if(ys4) {System.out.println("4");}
			
			if(ys1&&ys2&&ys3&ys4) {
				System.out.println("ִ�в���");
			String sql="INSERT INTO `lxr`.`stu` (`stuId`, `stuName`, `stuSex`, `stuAge`, `stuJg`, `stuDept`) VALUES ('"+stuId+"', '"+stuName+"', '"+stuSex+"', '"+stuAge+"', '"+stuJg+"', '"+stuDept+"')";
			System.out.println(sql);
			StuModle sm=new StuModle();
			if(!sm.newStu(sql)) {
				
				//��ʾ
				JOptionPane.showMessageDialog(this, "���ʧ�ܣ�");
				
			}else if(sm.newStu(sql)) {
				
				JOptionPane.showMessageDialog(this, "��ӳɹ���");
				
			}
			
			
			//�رնԻ���
			this.dispose();
			}
			
			
		}else if(e.getSource()==jb2) {
			
			//�رնԻ���
			this.dispose();
			
		}
		
		
	}

	
}
