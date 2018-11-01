package 记事本应用;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;



import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;


public class Notebook extends JFrame implements ActionListener{

	/**
	 * 添加ID
	 */
	private static final long serialVersionUID = 1L;
	
	
	//定义所需要的组件
	JTextArea jta=null;
	//创建菜单条
	JMenuBar jmb=null;
	//定义一个菜单项		
	JMenu jm1=null;
	//定义一个菜单子项
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	JMenuItem jmi3=null;
	
	
	public Notebook(){
		
		//初始化组建
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm1=new JMenu("文件");
		//设置助记符
		jm1.setMnemonic('F');
		jmi1=new JMenuItem("打开",new ImageIcon(" "));
		jmi3=new JMenuItem("保存",new ImageIcon(""));
		jmi2=new JMenuItem("另保存",new ImageIcon(" "));
		//添加菜单类组件
		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		//添加常用组件
		this.add(jta);
		
		//添加事件
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("custom_save");
		jmi3.addActionListener(this);
		jmi3.setActionCommand("save");
		
		//定义窗口
		this.setSize(800,600);
		this.setLocation(200,300);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Notebook note=new Notebook();
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		if(e.getActionCommand().contentEquals("open")) {
			
			System.out.println("open");
			
			//实例化一个文件选择器（文件选择对话框）
			JFileChooser jfc1=new JFileChooser();
			//设置标题
			jfc1.setDialogTitle("请选择文件");	
			//默认方式
			jfc1.showOpenDialog(null);
			//显示
			jfc1.setVisible(true);
			
			//得到用户选择的文件的绝对路径
			File f=new File(jfc1.getSelectedFile().getAbsolutePath());	
			System.out.print(f);
			
			FileReader fr=null;
			BufferedReader br=null;
			
			
			try {
				fr=new FileReader(f);
				br=new BufferedReader(fr);
				
				//该字符串用作读取内容，因为readline不能读取到\n\r
				String s="";
				//该自负床
				String all="";
				
				
				while((s=br.readLine())!=null) {
					
					all+=s+"\r\n";
					
				}
				
				//放置到Jta中文本区域中
				jta.setText(all);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		}else if(e.getActionCommand().equals("custom_save")){
			
			//出现对话框
			JFileChooser jfc2=new JFileChooser();
			jfc2.setDialogTitle("另存为");
			jfc2.showSaveDialog(null);
			jfc2.setVisible(true);
			
			//希望保存的路径
			File f=new File(jfc2.getSelectedFile().getAbsolutePath());
			
			//写入内容
			FileWriter fw=null;
			BufferedWriter bw=null;
			
			try {
				fw=new FileWriter(f);
				bw=new BufferedWriter(fw);
				//向其中写入
				bw.write(jta.getText());
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}finally {
				
				try {
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			
			
		}else if(e.getActionCommand().equals("save")){
				
					//写入内容
					FileWriter fw=null;
					BufferedWriter bw=null;
					
					//写入保存的时间
					Date date=new Date();
					SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd'@'hh-mm-ss");
					String filename=new String("文档("+sdf.format(date)+").txt");
					System.out.println(filename);
					
					
					//写入想保存的路径
					File f=new File(filename);
					
					
					if(!f.exists()) {
						try {
							f.createNewFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

					try {
					fw=new FileWriter(f);
					bw=new BufferedWriter(fw);
					//向其中写入
					bw.write(jta.getText());
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				    }finally {
					
					   try {
						bw.close();
					  } catch (IOException e1) {
						 // TODO Auto-generated catch block
						 e1.printStackTrace();
					 }

				}
				
				}
		}
	}
		
		
		

