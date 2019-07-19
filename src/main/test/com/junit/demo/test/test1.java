package com.junit.demo.test;

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i = 0; i <= 100; i ++) {
//			for(int j = 0; j <= 100; j ++) {
//				double sum = i * 3 + j * 2+ 0.5*(100 - j - i);
//				if(sum == 100.0) {
//					System.out.println(i + ", " + j+"," + (100 - i - j) );
//				}
//			}
//		}
		int totalCount = 20;
		int pageSize = 20;
		int totalPage = totalCount / pageSize;
		if (totalPage == 0 || totalCount % pageSize != 0) {
			totalPage++;
		}
		
		System.out.println(totalPage);
		
	}
	
	

}
