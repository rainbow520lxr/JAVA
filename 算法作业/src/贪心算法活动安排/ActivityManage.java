package ̰���㷨�����;

import java.util.Arrays;

public class ActivityManage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] s= {2,2,3,4,6,7,9,10,13};
		int[] f= {3,4,5,7,8,11,12,15,17};
		boolean[] a=new boolean[s.length];
		for(int i=0;i<s.length;i++)a[i]=false;
		ActivityManage am=new ActivityManage();
		int count=am.greedySelector(s, f, a);
		System.out.println("�����Ϊ��"+Arrays.toString(a)+" �����Ϊ��"+count);
		
		
	}
	
	
	public  int greedySelector(int[ ] s, int[ ] f, boolean a[ ])
	{

		a[0]=true;
		int j=0;
		int count=1;
		for(int i=1;i<s.length;i++){    //forѭ����i++����ѭ����ִ�����ִ��
			if(s[i]>=f[j]){
			a[i]=true;
			j=i;
			count++;
			}
			else a[i]=false;
			}
			return count;
	}

}
