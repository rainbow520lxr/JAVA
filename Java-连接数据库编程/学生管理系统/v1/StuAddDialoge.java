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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StuAddDialoge extends JDialog implements ActionListener{

	//�������
	JLabel jl[]=new JLabel[6];
	JButton jb1,jb2;
	JTextField jtf[]=new JTextField[6];
	JPanel jp[]=new JPanel[8];
	
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

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb1) {
			
			
			
		}else if(e.getSource()==jb2) {
			
			this.hide();
			
		}
		
		
	}

	
}
