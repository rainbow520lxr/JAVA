package ¶¯Ì¬¹æ»®;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MartriMultply {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int p[]= {10,100,5,50,30,20,60,45,50};
//		int p[]= {30, 35, 15, 5, 10, 20, 25};
		int[][] m = new int[p.length-1][p.length-1];
		int[][] s = new int[p.length-1][p.length-1];
		for(int i=0;i<m.length;i++) {
			m[i][i]=0;
			s[i][i]=0;
			//System.out.println(m[i][i]);
		}
		MartriMultply mm = new MartriMultply();
		mm.cacu(p, m, s);

	}
	
	
	public int[][] cacu(int p[], int m[][], int s[][]) {
		
		for(int index=1;index<p.length-1;index++) {
			
			for(int i=0,j=index;j<p.length-1;i++,j++) {				
				k(p, i, j, m, s);
				System.out.printf("m[%d][%d]:"+m[i][j]+" ",i,j);
				System.out.printf("s[%d][%d]:"+s[i][j]+"\n",i,j);
			}
			
		}
		
		
		return m;
	}

	public void k(int p[] ,int i ,int j, int[][] m, int[][] s) {
		
		int[] a=new int[j-i];
		int[] k_=new int[j-i];
		
		for(int k=i;k<j;k++) {
			//System.out.println(i+" "+j+":"+m[i][k]+" "+m[k+1][j]+" "+p[i]+" "+p[k+1]+" "+p[j+1]);
			a[k-i]=m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1];
			k_[k-i]=k+1;
			//System.out.println(i+" "+j+":"+a[k-i]);
			
		}	
		
		int temp=a[0],temp_k=k_[0];
		for(int index=0;index<a.length;index++) {
			if(a[index]<temp) {
				temp=a[index];
				temp_k=k_[index];
			}
		}
		m[i][j]=temp;
		s[i][j]=temp_k;


	}
	public int min(int a[]) {
		
		int temp=a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i]<temp) temp=a[i];
		}
		return temp;
	}
	
	
}
