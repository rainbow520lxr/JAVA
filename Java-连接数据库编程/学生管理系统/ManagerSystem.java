package ѧ������ϵͳ;

import java.awt.*;
import javax.swing.*;

public class ManagerSystem extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//�������
	JPanel jp1,jp2,jp3;
	JLabel jl;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4;
	JTable jt;
	

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
		
		jp2=new JPanel();
		jt=new JTable();
		this.add(jp2,BorderLayout.CENTER);
		jp2.add(jt);

		jp3=new JPanel();
		jb2=new JButton("����");
		jb3=new JButton("ɾ��");
		jb4=new JButton("�޸�");
		this.add(jp3,BorderLayout.SOUTH);
		jp3.setLayout(new FlowLayout());
		jp3.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);
		
		//����
		this.setLocation(300, 400);
		this.setSize(800, 600);
		this.setTitle("ѧ������ϵͳ");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManagerSystem ms=new ManagerSystem();
		
		
	}

}
