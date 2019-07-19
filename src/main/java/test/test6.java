package test;

import com.test.clone.Sudent;

class Str{
	private String str2 = "abc";
	private int x = 1;
	public String say() {
		String str = "abc";
		return str;
	}
	public void print() {
		String str = "abc";
		long y = new Integer(1);
		System.out.println(str == str2);
		System.out.println(x == y);
	}
}


public class test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Sudent su =  new Sudent("张三", 11);
		System.out.println(su);
		su.setAge(33);
		System.out.println(su);
		
		String s = new String("1");
//	    s.intern();
	    String s2 = "1";
	    String intern = s.intern();
	    System.out.println(s.intern() == s2);
	    System.out.println(intern == s2);
		
	    
	    
	    String s3 = new String("hello") + new String("hello");
        String s4 = "hellohello";
        String intern3 = s3.intern();
        System.out.println(intern3 == s4);
		
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1+str2;
        String str5 = "a"+"b";
        String str6 = str1+new String("b");
        String str7 = new String("ab");
        String str8 = new String(str3);
        System.out.println("---------------------");
        System.out.println(str3 == str4);
        System.out.println(str3 == str5);
        System.out.println(str3 == str6);
        System.out.println(str3 == str7);
        System.out.println(str3 == str8.intern());

        System.out.println("---------------------");
        new Str().print();
		
	}

}
