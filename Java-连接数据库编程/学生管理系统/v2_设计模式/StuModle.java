/*
 * �����ģ��1
 * Abstract����ܹ��˳������ṩĬ��ʵ�ִ󲿷ֵķ���TableModel�ӿڡ� ������������ڣ����ṩ��һЩ��������TableModelEvents�����䷢�͸����ڡ� Ҫ����һ������TableModel��Ϊһ������AbstractTableModel��ֻ��Ҫ����������������ʵ�֣� 
  public int getRowCount();
  public int getColumnCount();
  public Object getValueAt(int row, int column); 
 * 
 * *********************************
 * 
 * ######ҵ���߼���
 * 
 * �����Dao�㴦��ʲô��ִ���Ǹ����SQL���
 * 
 * 
 */

package ѧ������ϵͳ.v2_���ģʽ;


import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.Vector;


//����һ��ģ����ʵ�����б�Ҫ�Ľӿڷ�����������ģ��װ����������
public class StuModle extends AbstractTableModel{

	//����һ�������������е����ݼ�������
	private static Vector columnName,rowData; 
	
	//���ʼ��
	
	
	//sql���±����(���ɾ���޸�)
	public Boolean upStu(String sql,String[] paras) {
		
		//���ǲ���������Ҫ��ÿ�ζ�����һ�������ݿ������ܵ����ӣ������ǲ���������ԼӸ�static����Ϊȫ�ֱ���
		SqlHelper sh=new SqlHelper();
		return sh.upExcute(sql, paras);
		
	}


	//��ѯStu��(��ѯ�ı��ʾ��ǳ�ʼ��)
 	public void queryStu(String sql, String[] paras) {
		
 	
 		SqlHelper sh=null;
 		//��������
		columnName=new Vector();
		this.columnName.add("ѧ��");
		this.columnName.add("����");
		this.columnName.add("�Ա�");
		this.columnName.add("����");
		this.columnName.add("����");
		this.columnName.add("ϵ��");
		//�����
		this.rowData=new Vector();

		try {
			
			//���ò�ѯ���
			sh=new SqlHelper();
			ResultSet rs=sh.queryExcute(sql, paras);
	 		if(rs==null)System.out.println("û������!");
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
				this.rowData.add(hang);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {	
			//�ر�����
			sh.close();
		}		
		
		
	}
	
	
	//ʵ����tablemodel�Ľӿڵķ���,�������ڴ���ģ�Ͷ����ʱ���Զ�ʵ�ָ÷����룬���캯������
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
