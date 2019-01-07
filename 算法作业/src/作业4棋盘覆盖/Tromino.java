package ��ҵ4���̸���;

/*
 * ���ӻ������̸���
 * ������
 * 1.�����ʼ���̴�С
 * 2.�������ⷽ���λ��,����ֵΪ0
 * 3.�������еķ��񶼽�������������ͬ��������һ��L�͹���
 */


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.util.Scanner;

public class Tromino extends JFrame{
	
	//�������
	int t=1;
	int dr,dc;
	int N;
	JLabel[][] jl;
	int[][] a; 
	JPanel jp;

	

	public Tromino(int dr, int dc, int N) {
		// TODO Auto-generated constructor stub
		
		//������ʼ��
		this.N=N;
		jl=new JLabel[this.N][this.N];
		a = new int[this.N][this.N];
		this.dr=dr;
		this.dc=dc;
		this.a[this.dr][this.dc]=0;
		
		//��ʼ������
		tromino(this.a,this.dr,this.dc,0,0,this.N);

//		System.out.println("dr:"+this.dr+"dc:"+this.dc);
//		for(int i=0;i<16;i++) {
//			for(int j=0;j<16;j++) {
//				System.out.println(this.a[i][j]);
//			}
//		}
		
		//���ڲ���
		this.setLayout(new GridLayout(this.N, this.N));
		
		//��ʼ��������
		for(int i=0;i<this.N;i++) {
			for(int j=0;j<this.N;j++) {
				jl[i][j]=new JLabel(""+this.a[i][j],JLabel.CENTER);
				jl[i][j].setBorder(BorderFactory.createLineBorder(Color.GREEN));
				this.add(jl[i][j]);
			}
		}
		//jl[this.dr][this.dc].setText(""+0);
		
				
		//��������
		this.setSize(600, 600);
		this.setLocation(100, 100);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int dr,dc, N;
		Scanner sc=new Scanner(System.in);
		System.out.println("please input size of tormino(0��16�ڵ�2��ָ��������������):");
		N=sc.nextInt();
		System.out.println("please input dr(0<dr<16):");
		dr=sc.nextInt()-1;
		System.out.println("please input dr(0<dr<16):");
		dc=sc.nextInt()-1;
		Tromino t=new Tromino(dr, dc, N);
		
	}
	
	public void tromino(int a[][],int dr,int dc,int tr,int tc,int size)
	{
	  int s;
	  if(size==1) return;
	  if(size>1)
	  {
	     s=size/2;
	     if(dr<=(tr+s-1)&&dc<=(tc+s-1))       /*���ⷽ�������ϲ���*/
	     {
		 a[tr+s-1][tc+s]=t;
		 a[tr+s][tc+s]=t;
		 a[tr+s][tc+s-1]=t;
		 t++;
		 tromino(a,dr,dc,tr,tc,s);//���Ͻ������̵ݹ鴦��
		 tromino(a,tr+s-1,tc+s,tr,tc+s,s);//���Ͻ������̵ݹ鴦��
		 tromino(a,tr+s,tc+s,tr+s,tc+s,s);//���½������̵ݹ鴦��
		 tromino(a,tr+s,tc+s-1,tr+s,tc,s);//���½������̵ݹ鴦��
	     }
	     if(dr<=(tr+s-1)&&dc>(tc+s-1))	/*���ⷽ�������ϲ���*/
	     {
		 a[tr+s-1][tc+s-1]=t;
		 a[tr+s][tc+s-1]=t;
		 a[tr+s][tc+s]=t;
		 t++;
		 tromino(a,dr,dc,tr,tc+s,s); //���Ͻ������̵ݹ鴦��
		 tromino(a,tr+s-1,tc+s-1,tr,tc,s); //���Ͻ������̵ݹ鴦��
		 tromino(a,tr+s,tc+s-1,tr+s,tc,s); //���½������̵ݹ鴦��
		 tromino(a,tr+s,tc+s,tr+s,tc+s,s); //���½������̵ݹ鴦��
	      }
	     if(dr>(tr+s-1)&&dc<=(tc+s-1))	/*���ⷽ�������²���*/
	     {
		 a[tr+s-1][tc+s-1]=t;
		 a[tr+s-1][tc+s]=t;
		 a[tr+s][tc+s]=t;
		 t++;
		 tromino(a,dr,dc,tr+s,tc,s);
		 tromino(a,tr+s-1,tc+s-1,tr,tc,s);
		 tromino(a,tr+s-1,tc+s,tr,tc+s,s);
		 tromino(a,tr+s,tc+s,tr+s,tc+s,s);
	     }
	     if(dr>(tr+s-1)&&dc>(tc+s-1))	/*���ⷽ�������²���*/
	     {
		 a[tr+s][tc+s-1]=t;
		 a[tr+s-1][tc+s-1]=t;
		 a[tr+s-1][tc+s]=t;
		 t++;
		 tromino(a,dr,dc,tr+s,tc+s,s);
		 tromino(a,tr+s,tc+s-1,tr+s,tc,s);
		 tromino(a,tr+s-1,tc+s-1,tr,tc,s);
		 tromino(a,tr+s-1,tc+s,tr,tc+s,s);
	     }
	  }
	}



	

}
