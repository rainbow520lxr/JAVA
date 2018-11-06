/*
 * 建造表模型1
 * Abstract这个能够此抽象类提供默认实现大部分的方法TableModel接口。 它负责管理听众，并提供了一些方便生成TableModelEvents并将其发送给听众。 要创建一个具体TableModel作为一个子类AbstractTableModel你只需要对以下三个方法的实现： 
  public int getRowCount();
  public int getColumnCount();
  public Object getValueAt(int row, int column); 
 * 
 * *********************************
 * 
 * ######业务逻辑层
 * 
 * 会告诉Dao层处理什么表，执行那个表的SQL语句
 * 
 * 
 */

package 学生管理系统.v2_设计模式;


import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.Vector;


//定义一个模型类实现其中必要的接口方法，将数据模型装到表容器中
public class StuModle extends AbstractTableModel{

	//定义一个列名向量，行的数据集合向量
	private static Vector columnName,rowData; 
	
	//表初始化
	
	
	//sql更新表语句(添加删除修改)
	public Boolean upStu(String sql,String[] paras) {
		
		//考虑并发性所以要在每次都创建一个新数据库语句接受的连接，不考虑并发性则可以加个static升级为全局变量
		SqlHelper sh=new SqlHelper();
		return sh.upExcute(sql, paras);
		
	}


	//查询Stu表(查询的本质就是初始化)
 	public void queryStu(String sql, String[] paras) {
		
 	
 		SqlHelper sh=null;
 		//设置列名
		columnName=new Vector();
		this.columnName.add("学号");
		this.columnName.add("姓名");
		this.columnName.add("性别");
		this.columnName.add("年龄");
		this.columnName.add("籍贯");
		this.columnName.add("系别");
		//添加行
		this.rowData=new Vector();

		try {
			
			//调用查询语句
			sh=new SqlHelper();
			ResultSet rs=sh.queryExcute(sql, paras);
	 		if(rs==null)System.out.println("没有数据!");
			while(rs.next()) {	
				
				//rowData可以存放多行
				//定义一个向量来装每行的行数据
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getInt(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				//将行添加进去
				this.rowData.add(hang);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {	
			//关闭连接
			sh.close();
		}		
		
		
	}
	
	
	//实现了tablemodel的接口的方法,而且是在创建模型对象的时候自动实现该方法与，构造函数很像
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
	//得到某行某列的数据
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		//先要拿到行向量，再在行向量中拿到其中一个列数据，需要强转
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}

	//得到列名
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		//需要强转
		return (String) this.columnName.get(column);
	}
	
	
}
