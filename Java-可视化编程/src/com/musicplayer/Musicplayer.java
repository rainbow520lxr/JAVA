package com.musicplayer;



import java.awt.*;

import javax.swing.*;

public  class Musicplayer extends JFrame{
	
	private static final long serialVersionUID = 10L; 

	//�����齨
	private JPanel jp1,jp2;
	private JButton jbt1,jbt2;
	private JTextField jtf;
	
	
	public Musicplayer() {
		
		//��ʼ���齨
		this.jp1=new JPanel();
		this.jp2=new JPanel();
		
		this.jtf=new JTextField(22);
		
		this.jbt1=new JButton("����");
		this.jbt2=new JButton("��ͣ");
		
		//���ò���
		this.setLayout(new BorderLayout());
		
		
		//������
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		
		jp1.add(jtf);
		jp2.add(jbt1);
		jp2.add(jbt2);
		
		
		
		//��ʼ������
		this.setLocation(200, 300);
		this.setSize(400,300);
		this.setResizable(false);
		this.setTitle("���ֲ�����");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public static void main(String[] args) {
		
		Musicplayer player=new Musicplayer();
		
	}
		
	
	
}
