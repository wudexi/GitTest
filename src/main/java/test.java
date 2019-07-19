import org.apache.commons.lang.StringUtils;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a="";
		//System.out.println(StringUtils.isBlank(a));
		
		String str = "abc";
		//String[] ss = str.split(";");
		//System.out.println(ss.length);
		
		//str.substring(str.length(),1);
//		String ss ="";
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.substring(str.length()-1-i, str.length()-i));
		}
		//str = new StringBuffer(str).reverse().toString();
		//System.out.println(str);
		
		
	}

}
