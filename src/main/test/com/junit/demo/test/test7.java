package com.junit.demo.test;

public class test7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OK: // 设置一个标记 使用带此标记的break语句跳出多重循环体	
		for (int i = 1; i < 100; i++) { // 让i循环99次
			for (int j = 1; j <= i; j++) {
				if (i == 10) {
					break OK;
				}
				System.out.print(i + "*" + j + "=" + i * j);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
