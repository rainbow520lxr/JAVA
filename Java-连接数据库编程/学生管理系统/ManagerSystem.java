/*
 * �����ݿ��������
 * ĿǰJDBC����������һ����cj.dricverһ����driver
 * ��������������ʱ��֮���
 * 
 */


package ѧ������ϵͳ;

import java.awt.*;
import java.util.Vector;
import java.sql.*;
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
	//����һ����
	JTable jt;
	JScrollPane jsp;
	
	//�������
	Vector rowData,columnName;
	String url="jdbc:mysql://localhost:3306/lxr?userUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
	String username="root";
	String password="lixin2008";
	//����sql���
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

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
		columnName=new Vector();
		//��������
		columnName.add("ѧ��");
		columnName.add("����");
		columnName.add("�Ա�");
		columnName.add("����");
		columnName.add("����");
		columnName.add("ϵ��");
		
		//�����
		rowData=new Vector();
		
//		//����һ��������
//		Vector hang=new Vector();
//		hang.add("001");
//		hang.add("�����");
//		hang.add("��");
//		hang.add("10000");
//		hang.add("����ɽ");
//		hang.add("��������");
//		//���������ݼ��뵽rowData��
//		rowData.add(hang);
		//��ʼ�����jtable
		
		//��������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=(Connection)DriverManager.getConnection(url,username,password);
			ps=conn.prepareStatement("select * from stu");
			//rs��һ��ָ��ָ���һ�У���java������rs.next()�Զ�ָ���ƶ�
			rs=ps.executeQuery();
			
			while(rs.next()) {				
				//rowData���Դ�Ŷ���
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getInt(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				//������ӽ�ȥ
				rowData.add(hang);				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			try {	
				if(conn!=null) {conn.close();}
				if(ps!=null) {ps.close();}
				if(rs!=null) {rs.close();}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		jt=new JTable(rowData,columnName);
		jsp=new JScrollPane(jt);
		this.add(jp2,BorderLayout.CENTER);
		//��jsp������jframe
		jp2.add(jsp);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		

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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManagerSystem ms=new ManagerSystem();
		
		
	}

}
