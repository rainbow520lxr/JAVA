package ��ҵ5�ϲ�����;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array= {3, 4, 1, 2, 9, 7, 22, 11, 34, 6};
		MergeSort ms=new MergeSort();
		System.out.println("δ�������"+Arrays.toString(array));
		ms.mergeSort(array);
		System.out.println("������Ͼ���:"+Arrays.toString(array));
	

}

	public static void mergeSort(int[]array){
	   
	  int length=array.length;
	  int middle=length/2;
	 
	  if(length>1){
	    int[]left=Arrays.copyOfRange(array,0,middle);//��������array����벿��
	    int[]right=Arrays.copyOfRange(array,middle,length);//��������array���Ұ벿��
	    mergeSort(left);//�ݹ�array����벿��
	    mergeSort(right);//�ݹ�array���Ұ벿��
	    merge(array,left,right);//������벿�֡��Ұ벿�ֺϲ���Array
	  }
	}
	 
	//�ϲ����飬����
	private static void merge(int[]result,int[]left,int[]right){
	 
	  int i=0,l=0,r=0;
	 
	  while(l<left.length&&r<right.length){
	    if(left[l]<right[r]){
	      result[i]=left[l];
	      i++;
	      l++;
	    }else{
	      result[i]=right[r];
	      i++;
	      r++;
	   }
	  }
	 
	  while(r<right.length){//����ұ�ʣ�ºϲ��ұߵ�
	    result[i]=right[r];
	    r++;
	    i++;
	  }
	 
	  while(l<left.length){
	    result[i]=left[l];
	    l++;
	    i++;
	  }
	
	}}