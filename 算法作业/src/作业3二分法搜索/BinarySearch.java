package ��ҵ3���ַ�����;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {1, 2, 5, 7, 10, 22, 32, 40, 59, 78};
		int x, index;
		int left = 0;
		int right = a.length-1;
		
		BinarySearch bs = new BinarySearch();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("������������ҵ�����:");
			x = sc.nextInt();
			if(x == -1) {System.out.println("����ֹͣ��");break;}
			System.out.println(bs.binarySearch(a, x, left, right));
		}
	}
	
	
	//���ֲ���
	String binarySearch(int a[], int x, int left, int right) {
		
	    while (right >= left){ 
	        int mid = (left+right)/2;
	        if (x == a[mid]) return "������λ��index:"+mid;
	        if (x < a[mid]) right = mid-1; 
	        else left = mid+1;
	    }
	    return "δ�ҵ�������(����-1��ʾ���������������\nС�������������λ��index:"+argmax(a, x)+"\n����������С����λ��index:"+argmin(a, x) ;
	} 

	
	//����С��ĳ�����������
	public int argmin(int a[], int x) {
		
		int i = 0;
		if(a[i] > x)return -1;
		while(a[i++] < x && i<=a.length-1);
		return i-1;
		
	}

	
	//��������ĳ��������С��
	public int argmax(int a[], int x) {
		
		int i = a.length-1;
		if(a[i] < x)return -1;
		while(a[i--] > x && i >= 0);	
		return i+1;
		
	}
	
	
	
}
