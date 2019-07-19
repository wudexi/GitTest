import javax.servlet.jsp.tagext.TryCatchFinally;

import org.junit.Test;


public class test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 720 ;
		double x = 500;
		double p = 12.5;
		
		 double j =(p/a)*x;
		 double y = (p/a)*a;
		System.out.println(j);;
		System.out.println(y);
		
		//System.out.println(new test3().get(1000));
		
	}
	
	
	public int get(int a) {
		int b=0;
		
		try {
			
			return b;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			b = 100;
			return b;
		}
	}
}
