package ���±�Ӧ��;
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
	 * ���ID
	 */
	private static final long serialVersionUID = 1L;
	
	
	//��������Ҫ�����
	JTextArea jta=null;
	//�����˵���
	JMenuBar jmb=null;
	//����һ���˵���		
	JMenu jm1=null;
	//����һ���˵�����
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	JMenuItem jmi3=null;
	
	
	public Notebook(){
		
		//��ʼ���齨
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm1=new JMenu("�ļ�");
		//�������Ƿ�
		jm1.setMnemonic('F');
		jmi1=new JMenuItem("��",new ImageIcon(" "));
		jmi3=new JMenuItem("����",new ImageIcon(""));
		jmi2=new JMenuItem("����",new ImageIcon(" "));
		//��Ӳ˵������
		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		//��ӳ������
		this.add(jta);
		
		//����¼�
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("custom_save");
		jmi3.addActionListener(this);
		jmi3.setActionCommand("save");
		
		//���崰��
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
			
			//ʵ����һ���ļ�ѡ�������ļ�ѡ��Ի���
			JFileChooser jfc1=new JFileChooser();
			//���ñ���
			jfc1.setDialogTitle("��ѡ���ļ�");	
			//Ĭ�Ϸ�ʽ
			jfc1.showOpenDialog(null);
			//��ʾ
			jfc1.setVisible(true);
			
			//�õ��û�ѡ����ļ��ľ���·��
			File f=new File(jfc1.getSelectedFile().getAbsolutePath());	
			System.out.print(f);
			
			FileReader fr=null;
			BufferedReader br=null;
			
			
			try {
				fr=new FileReader(f);
				br=new BufferedReader(fr);
				
				//���ַ���������ȡ���ݣ���Ϊreadline���ܶ�ȡ��\n\r
				String s="";
				//���Ը���
				String all="";
				
				
				while((s=br.readLine())!=null) {
					
					all+=s+"\r\n";
					
				}
				
				//���õ�Jta���ı�������
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
			
			//���ֶԻ���
			JFileChooser jfc2=new JFileChooser();
			jfc2.setDialogTitle("���Ϊ");
			jfc2.showSaveDialog(null);
			jfc2.setVisible(true);
			
			//ϣ�������·��
			File f=new File(jfc2.getSelectedFile().getAbsolutePath());
			
			//д������
			FileWriter fw=null;
			BufferedWriter bw=null;
			
			try {
				fw=new FileWriter(f);
				bw=new BufferedWriter(fw);
				//������д��
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
				
					//д������
					FileWriter fw=null;
					BufferedWriter bw=null;
					
					//д�뱣���ʱ��
					Date date=new Date();
					SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd'@'hh-mm-ss");
					String filename=new String("�ĵ�("+sdf.format(date)+").txt");
					System.out.println(filename);
					
					
					//д���뱣���·��
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
					//������д��
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
		
		
		

