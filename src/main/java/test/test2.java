package test;

public class test2 {
	static int z = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1=" ab";
		String s2=" a"+" b";
		String s3=" a";
		String s4=" b";
		String s5=s3+s4;
		System.out.println("s5:"+s5);
		System.out.println("s2:"+s2);
		System.out.println(s5==s2);
		
		String ss1="aa"; 
		String ss2=ss1.intern(); 
		
		System.out.println(ss1==ss2);//返回true
		String x = "abc";
		String y = "abc";
		System.out.println(x == y);
		System.out.println("x:"+x.hashCode());
		x =x.intern()+"abc";
		//x="abc1";
		System.out.println("x:"+x.hashCode());
		
		int i = 1;
		Integer j = new Integer(1);
		System.out.println(i == j);
		test2.z = 2;
		System.out.println(test2.z);
		
	}

}
