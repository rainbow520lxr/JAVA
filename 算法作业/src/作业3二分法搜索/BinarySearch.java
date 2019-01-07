package 作业3二分法搜索;

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
			System.out.println("请输入你想查找的数字:");
			x = sc.nextInt();
			if(x == -1) {System.out.println("查找停止！");break;}
			System.out.println(bs.binarySearch(a, x, left, right));
		}
	}
	
	
	//二分查找
	String binarySearch(int a[], int x, int left, int right) {
		
	    while (right >= left){ 
	        int mid = (left+right)/2;
	        if (x == a[mid]) return "该数字位置index:"+mid;
	        if (x < a[mid]) right = mid-1; 
	        else left = mid+1;
	    }
	    return "未找到该数字(参数-1表示不存在这个数）。\n小于它的最大数字位置index:"+argmax(a, x)+"\n大于它的最小数字位置index:"+argmin(a, x) ;
	} 

	
	//搜索小于某个数的最大数
	public int argmin(int a[], int x) {
		
		int i = 0;
		if(a[i] > x)return -1;
		while(a[i++] < x && i<=a.length-1);
		return i-1;
		
	}

	
	//搜索大于某个数的最小数
	public int argmax(int a[], int x) {
		
		int i = a.length-1;
		if(a[i] < x)return -1;
		while(a[i--] > x && i >= 0);	
		return i+1;
		
	}
	
	
	
}
