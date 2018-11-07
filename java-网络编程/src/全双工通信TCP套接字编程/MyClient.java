package ȫ˫��ͨ��TCP�׽��ֱ��;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MyClient extends JFrame implements ActionListener,KeyListener{

	//�������
	JPanel jp;
	JScrollPane jsp;
	//�������
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	
	//�������
	Socket s=null;
	BufferedReader br=null;
	BufferedWriter bw=null;
	String in=null;
	String out=null;
	
	public MyClient() {
		
		//��ʼ��
		jp=new JPanel();
		jta=new JTextArea();
		jta.setEditable(false);
		jsp=new JScrollPane(jta);
		jtf=new JTextField(20);
		jb=new JButton("����");
		
		//����
		this.setLayout(new BorderLayout());
		this.add(jsp,"Center");
		this.add(jp,"South");
		jp.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//������
		jp.add(jb);
		jp.add(jtf);
		
		//����¼�
		jb.addActionListener(this);
		jtf.addKeyListener(this);
		
		//��ʼ������
		this.setTitle("�ͻ���");
		this.setLocation(300, 300);
		this.setSize(400,300);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�׽���
		try {
			//1.���������׽���
			s=new Socket("192.168.1.103",4000);
			//2.���������������
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			//3.����Ự������Ϣ
			while(true) {
				in=br.readLine();
				//׷��
				jta.append(in+"\r\n");
			}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(s!=null)s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MyClient mc=new MyClient();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb) {
			
			out="�ͻ���:"+jtf.getText()+"\r\n";
			try {
				bw.write(out);
				bw.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//׷����Ϣ
			jta.append(out);
			//���
			jtf.setText("");
			
		}
		
	}








	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyChar()==KeyEvent.VK_ENTER) {
			
				
			out="�ͻ���:"+jtf.getText()+"\r\n";
			try {
				bw.write(out);
				bw.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//׷����Ϣ
			jta.append(out);
				//���
			jtf.setText("");	
		}
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}






}
