package 作业2快速排序三者取中;

//排序采用三者取首

public class QuickSort{
	
	public int index;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//自定义数组序列
		int a[] = {6, 7, 4, 3, 3, 5};
		int p = 0;
		int r = 5;

		//排序
		QuickSort qs = new QuickSort();	
		System.out.print("排序前：");
		for(int i = 0; i <=5; i++)System.out.print(a[i]+" ");
		qs.quickSort(a, p, r);
		System.out.println();
		System.out.print("排序后：");
		for(int i = 0; i <=5; i++)System.out.print(a[i]+" ");
		

		

	}
	
	//快速排序
	public void quickSort(int a[], int p, int r) {
		
		if(p < r) {
			//for(int i = 0; i <=5; i++)System.out.print(a[i]+" ");
			//System.out.println();
			int q = partition(a, p, r);
			//for(int i = 0; i <=5; i++)System.out.print(a[i]+" ");
			//System.out.println();
			quickSort(a, p, q-1);
			quickSort(a, q+1, r);
		}
		
	}

	//划分关键记录
	public int partition (int a[], int p, int r) {
		
		int i = p;
		int j = r;
		int x = a[(int)(p+r)/2];
		//System.out.println("x:"+x);
		
		if(j>i) {
			while(a[j] >= x && j !=i)j--;
			swap(a, (int)(p+r)/2, j);	
		}
		
		while(true) {
			
			if(j>i) {
				while(a[i] < x) i++;
				swap(a, i, j);
				//System.out.println(i);
				while(a[j] >= x && j !=i)j--;
				swap(a, i, j);
				//System.out.println(j);
			}else break;
			
			
				
		}
		return j;
		

	}
	
	public void swap(int a[], int i, int j) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
