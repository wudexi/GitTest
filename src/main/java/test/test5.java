package test;

class A{
	static{
		System.out.print("1");
	}
	public A(){
		System.out.print("2");
	}
}
class B extends A{
	static{
		System.out.print("a");
	}
	public B(){
		System.out.print("b");
	}
}
 class C{
	
	public static void say(String[] str) {
		str[0] = "java";
	}
}

public class test5 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A ab = new B();
		ab = new B();
		
		String[] str = new String[]{"aaa"};
		C.say(str);
		System.out.println(str[0]);
	}

}
