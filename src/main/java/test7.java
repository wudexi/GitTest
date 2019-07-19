



class A {
	int a=1;
	double d = 2.0;
	int x= 0;
	void show(){
		System.out.println("Class A:a="+a+"\td="+d);
	}
	void show1(){
		
	}
}
class B extends A{
	float a=3.0f;
	String d="Java program.";
	void show(){
		//super.show();
		System.out.println("Class B:a="+a+"\td="+d);
	}
}
class C extends B{
	 public C(){
	 }
	 
}
public class test7 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A a = new A();
		a.show();
		System.out.println("================");
		A b = new B();
		b.show();
	}

}
