
public class test6 {

	/**
	 * @param args
	 */
	String str = new  String("good");
	char[] ch = {'a','b','c'};
	int a = 0;
	String s = new String("php");
	public void change(String str,char ch[]) {
		str = "test ok";
		ch[0] ='g';
		s = "java";
	}
	public void change() {
		str = "test ok";
		ch[0] ='g';
		s = "java";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test6 t = new test6();
		
		t.change(t.str, t.ch);
		System.out.print(t.str+" and ");
		System.out.print(t.ch);;
		System.out.println(t.s);
		
	}
	
}
