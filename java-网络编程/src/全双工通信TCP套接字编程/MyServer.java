package 全双工通信TCP套接字编程;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyServer extends JFrame implements ActionListener,KeyListener{

	//定义面板
	JPanel jp;
	JScrollPane jsp;
	//定义组件
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	
	//定义变量
	ServerSocket ss=null;
	Socket s=null;
	BufferedReader br=null;
	BufferedWriter bw=null;
	String in=null;
	String out=null;
	
	public MyServer() {
		
		//初始化
		jp=new JPanel();
		jta=new JTextArea();
		jta.setEditable(false);
		jsp=new JScrollPane(jta);
		jtf=new JTextField(20);
		jb=new JButton("发送");
		
		//布局
		this.setLayout(new BorderLayout());
		this.add(jsp,"Center");
		this.add(jp,"South");
		jp.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//添加组件
		jp.add(jb);
		jp.add(jtf);
		
		//添加事件
		jb.addActionListener(this);
		jtf.addActionListener(this);
		jtf.addKeyListener(this);
		
		//初始化窗口
		this.setTitle("服务端");
		this.setLocation(300, 300);
		this.setSize(400,300);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try {
			//1.建立监听套接字
			ss=new ServerSocket(4000);
			//2.开始接收请求套接字
			s=ss.accept();
			//3.创建输入输出流
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			//4.监听消息
			while(true) {	
				//输入
				in=br.readLine();
				//追加
				jta.append(in+"\r\n");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(ss!=null)ss.close();
					if(s!=null)s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MyServer ms=new MyServer();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb) {
			
			out="服务器:"+jtf.getText()+"\r\n";
			try {
				bw.write(out);
				bw.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//追加消息
			jta.append(out);
			//清空发送框的内容
			jtf.setText("");	
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar()==KeyEvent.VK_ENTER) {
			
			out="服务器:"+jtf.getText()+"\r\n";
			try {
				bw.write(out);
				bw.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//追加消息
			jta.append(out);
			//清空发送框的内容
			jtf.setText("");			
			
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	out="服务器:"+jtf.getText()+"\r\n";
	try {
		bw.write(out);
		bw.flush();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	//追加消息
	out="服务器:"+jtf.getText()+"\r\n";
	try {
		bw.write(out);
		bw.flush();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	//追加消息
	jta.append(out);
	//清空发送框的内容
	jtf.setText("");
	jta.append(out);
	//清空发送框的内容
	jtf.setText("");

}
