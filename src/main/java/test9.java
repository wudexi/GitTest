public class test9 {

	/**
	 * @param args
	 *            递归介乘之和
	 */

	static long fact(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * fact(n - 1);
		}
	}

	public static void main(String[] args) {
		int x = 3; // 1+2*1+3*2*1+4*3*2*1
		
		int total =0;
		for (int i = 1; i <= 3; i++) {
			total+=fact(i);
		}
		
		System.out.println(x + "的阶乘结果是："+fact(x));  
		System.out.println(x+"的阶乘之和："+total);
	}

}
