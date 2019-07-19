package com.junit.demo.test;

public class test10 {
	
	public static void print(StringBuffer i) {
//		i = null;
		i.append(" word");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("holle");
		print(sb);
		System.out.println(sb);
	}

}
