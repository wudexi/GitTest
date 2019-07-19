package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.test.clone.Sudent;

public class Reflection {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Class  cla = Class.forName("com.test.clone.Sudent");
//		Object obj = cla.newInstance();
		Constructor cons = 	cla.getConstructor(String.class,int.class);
		Object obj = cons.newInstance("张三",11);
		Sudent s = (Sudent) obj;
		
		System.out.println(s.toString());
		Class  cla2 = Sudent.class;
		Constructor cons2 = cla2.getConstructor(String.class,int.class);
		Object obj2 = cons2.newInstance("a",1);
		Sudent s2 = (Sudent) obj2;
		System.out.println(s2.toString());
		
	}

}
