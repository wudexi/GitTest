package com.junit.demo.test;

public class test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a ={44,21,3,45,4,2,33};
		int max =0;
//		for (int i = 0; i < a.length; i++) {
//			for (int j = i+1; j < a.length; j++) {
//				if(a[i]>a[j]){
//					int temp = a[i];
////					a[i] = a[j];
////					a[j]=temp;
//					System.out.println(temp);
//				}
//			
//			}
//			
//		}
	//	max = a[0];
		for (int k = 0; k < a.length; k++) {
			if(a[k]>max) max = a[k];
			//System.out.print(a[k]+" ");
			
		}
	
		System.out.println(max);
		
	}

}
