/*
 *�������ܣ�
 *ʵ����ɾ�Ĳ飬�԰�ť���¼�
 *����ͬһ�����������ʹ��e.getSource����ȡ������Ϣ�����Բ���setActionCommand
 *���ݿ�ı�Ĳ������з⣬������ÿ�ε����Ӧ������ʱ��Ҫдһ��jdbc���ӣ������������
 *������ģ��
 *
 *
 */


package ѧ������ϵͳ.v1;

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
	private JButton jb1,jb2,jb3,jb4;
	//����һ����
	private JTable jt;
	private JScrollPane jsp;
	private StuModle sm;
	
	
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
		this.add(jp3,BorderLayout.SOUTH);
		jp3.setLayout(new FlowLayout());
		jp3.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);
		
		//����¼�
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		
		
		//����
		this.setLocation(300, 400);
		this.setSize(800, 600);
		this.setTitle("ѧ������ϵͳ");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManagerSystem ms=new ManagerSystem();
		
		
	}

//�¼�����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1) {
			
			System.out.println("���в�ѯ...");
			//��Ϊ�ѶԱ�����ݷ�װ����StuModel�У����ǾͿ��ԱȽϼ򵥵���ɲ�ѯ
			String name=this.jtf.getText().trim();//ʹ��trim��ǰ���Ϳ��ַ�ɾȥ
			//дһ����ѯ��sql���
			String sql="select * from stu where stuName='"+name+"'";
			//����һ����ִ���˲�ѯ����ģ�ͱ�
			StuModle sm=new StuModle(sql);
			//���¼��ص�jtable��ģ��
			jt.setModel(sm);
			System.out.println(sql);
			
		}else if(e.getSource()==jb2) {
			
			StuAddDialoge sad=new StuAddDialoge(this, "���ѧ��", true);
			
			
			
		}
		
		
	}

}
