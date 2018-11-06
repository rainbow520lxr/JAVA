/*
 *�������ܣ�
 *ʵ����ɾ�Ĳ飬�԰�ť���¼�
 *����ͬһ�����������ʹ��e.getSource����ȡ������Ϣ�����Բ���setActionCommand
 *���ݿ�ı�Ĳ������з⣬������ÿ�ε����Ӧ������ʱ��Ҫдһ��jdbc���ӣ������������
 *������ģ��
 *
 *
 */


package ѧ������ϵͳ.v2_���ģʽ;

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
	
	//�������
	private JPanel jp1,jp3;
	private JLabel jl;
	private JTextField jtf;
	private JButton jb1,jb2,jb3,jb4,jb5;
	//����һ����
	private JTable jt;
	private JScrollPane jsp;
	private static StuModle sm;
	
	
	//�������
	private String record="";
	
	//���캯��
	public ManagerSystem() {
		
		//�������岼��
		this.setLayout(new BorderLayout());
	
		
		//��ʼ�����
		jp1=new JPanel();
		jl=new JLabel("���������֣�");
		jtf=new JTextField(22);
		jb1=new JButton("��ѯ");
		this.add(jp1,BorderLayout.NORTH	);
		jp1.setLayout(new FlowLayout());
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		
		sm=new StuModle();
		sm.queryStu("select * from lxr.stu", null);
		jt=new JTable(sm);
		jt.getTableHeader().setResizingAllowed(false); 
		jt.getTableHeader().setReorderingAllowed(false);
		jsp=new JScrollPane(jt);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(jsp,BorderLayout.CENTER);
		//��jsp������jframe
		
		jp3=new JPanel();
		jb2=new JButton("���");
		jb3=new JButton("ɾ��");
		jb4=new JButton("�޸�");
		jb5=new JButton("����");
		this.add(jp3,BorderLayout.SOUTH);
		jp3.setLayout(new FlowLayout());
		jp3.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);
		jp3.add(jb5);
		
		//����¼�
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		
		//����
		this.setSize(800, 600);
		this.setTitle("ѧ������ϵͳ");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
	//������
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManagerSystem ms=new ManagerSystem();
		
		
	}

	
	//�¼�����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//��ѯ
		if(e.getSource()==jb1) {
			
			//��Ϊ�ѶԱ�����ݷ�װ����StuModel�У����ǾͿ��ԱȽϼ򵥵���ɲ�ѯ
			String[] paras= {this.jtf.getText().trim()};//ʹ��trim��ǰ���Ϳ��ַ�ɾȥ
			//����һ����ִ���˲�ѯ����ģ�ͱ�
		    sm.queryStu("select * from lxr.stu where stuName=?", paras);
			//���¼��ص�jtable��ģ��
		    sm=new StuModle();
			this.jt.setModel(sm);

		//���
		}else if(e.getSource()==jb2) {
			
			StuAddDialoge sad=new StuAddDialoge(this, "���ѧ��", true);
			//����
			sm=new StuModle();
			jt.setModel(sm);
				
		//ɾ��
		}else if(e.getSource()==jb3) {
			
			if(jt.getSelectedRow()==-1) {				
				JOptionPane.showMessageDialog(this, "��ѡ��һ��ɾ����");
				return;
			}
			String stuId=(String) jt.getValueAt(jt.getSelectedRow(), 0);
			String[] paras= {stuId};
			sm.upStu("DELETE FROM `lxr`.`stu` WHERE (`stuId` = ?)", paras);
			sm.queryStu("select * from lxr.stu", null);
			//����
			sm=new StuModle();
			jt.setModel(sm);
			
		//�޸�
		}else if(e.getSource()==jb4) {
			
			
			if(jt.getSelectedRowCount()!=1) {
							
				JOptionPane.showMessageDialog(this, "��ѡ��һ���޸ģ�");
				return;
				
			}
			
			//��Ĭ�����ݷ�װ�����Ӵ��ڶ���
			String stu[]=new String[6];
			for(int i=0;i<6;i++) {				
				stu[i]=  jt.getValueAt(jt.getSelectedRow(), i).toString();
				System.out.println(stu[i]);
			}
			//�޸�
			StuDelDialoge sad=new StuDelDialoge(this, "�޸�ѧ��", true, stu, jt.getSelectedColumn());
			//����
			sm=new StuModle();
			jt.setModel(sm);
			
			
			
		}else if(e.getSource()==jb5) {

			sm.queryStu("select * from lxr.stu", null);
			//����
			sm=new StuModle();
			jt.setModel(sm);
		}
		
		
	}

}
