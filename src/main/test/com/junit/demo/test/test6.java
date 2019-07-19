package com.junit.demo.test;


public class test6 {

	/**
	 * @param args
	 */
	
	public int  get() {
		int i =0;
		try {
			i++;
			return i+50;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			i=1000;
		}
		return i;
		
		//return 0;
	}
	public static int print() {
        int c = 1;
        try {
            c++;
            System.out.println(c);
            System.out.println("try");
            return c+100; //--------1
        }finally {
            c++;
            System.out.println(c);
            System.out.println("finally");
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int  i=0;
//		try {
//			
//			
//		} catch (Exception e) {
//			
//		}finally{
//			System.out.println("finally....");
//		}
//		
		test6 t6 = new test6();
		System.out.println(t6.get());
		
	 // System.out.println(test6.print());
	}

}
