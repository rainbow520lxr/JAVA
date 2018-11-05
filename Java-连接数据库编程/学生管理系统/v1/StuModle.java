/*
 * �����ģ��1
 * Abstract����ܹ��˳������ṩĬ��ʵ�ִ󲿷ֵķ���TableModel�ӿڡ� ������������ڣ����ṩ��һЩ��������TableModelEvents�����䷢�͸����ڡ� Ҫ����һ������TableModel��Ϊһ������AbstractTableModel��ֻ��Ҫ����������������ʵ�֣� 
  public int getRowCount();
  public int getColumnCount();
  public Object getValueAt(int row, int column); 
 * 
 * 
 */

package ѧ������ϵͳ.v1;


import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.Vector;


public class StuModle extends AbstractTableModel{


	//�������
	private String url="jdbc:mysql://localhost:3306/lxr?userUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
	private String username="root";
	private String passwd="lixin2008";
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private Vector columnName,rowData; 
	
	
	
	
	//��̬��,���캯��
	//���캯��1,����sql��䴦����ȷ��ѯ����
	public StuModle(String sql) {
		
		this.init(sql);
		
	}
	//���캯��2��ʵ���б�ĳ�ʼ����ʾ
	public StuModle() {
		
		this.init("");
		
	}
	
	
	//����sql���,���ɾ���޸�
	public Boolean newStu(String sql) {
		Boolean flag=true;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=(Connection)DriverManager.getConnection(url,username,passwd);
			ps=conn.prepareStatement(sql);
				
			//rs��һ��ָ��ָ���һ�У���java������rs.next()�Զ�ָ���ƶ�
			int rs=ps.executeUpdate();
			if(rs!=-1) {
				System.out.println("�����ɹ�!");
				flag=false;
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				
				flag=false;
				
				
			}finally {
				 
				try {
					if(conn!=null)conn.close();
					if(ps!=null) {ps.close();}
					if(rs!=null) {rs.close();}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					
				}
				
			}
	
		return flag;
	}
	
	public void delStu() {
		
		
		
	}
	
	public void changeStu() {
		
		
	}
	
	
	//��ʼ��ִ��sql���,����������
 	public void init(String sql) {
		
		if(sql.contentEquals("")) {
			
			sql="select * from stu";
		}
		
		
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
			conn=(Connection)DriverManager.getConnection(url,username,passwd);
			ps=conn.prepareStatement(sql);
			//rs��һ��ָ��ָ���һ�У���java������rs.next()�Զ�ָ���ƶ�
			rs=ps.executeQuery();
			
			while(rs.next()) {				
				//rowData���Դ�Ŷ���
				//����һ��������װÿ�е�������
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
		
		
		
	}
	
	
	//ʵ����tablemodel�Ľӿڵķ���,�������ڴ��������ʱ���Զ�ʵ�ָ÷����룬���캯������
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnName.size();
	}

	@Override
	//�õ�ĳ��ĳ�е�����
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		//��Ҫ�õ����������������������õ�����һ�������ݣ���Ҫǿת
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}

	//�õ�����
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		//��Ҫǿת
		return (String) this.columnName.get(column);
	}
	
	
}
