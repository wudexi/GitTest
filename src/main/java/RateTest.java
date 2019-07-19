
public class RateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double fee=12340;
		double fee1=14000;
		double x = 3500;
		double x1 = 5000;  //
		double sb = 380.34+105; // 社保
		double j = 555;
		double j1 = 210;
		
		double rt = (fee-sb-x1)*0.1-j1;
		double rt2 = (fee1-sb-x1)*0.1-j1;
		System.out.println("税："+rt);
		System.out.println("(new)税："+rt2);
		System.out.println("应得工资："+(fee-sb-rt));
		System.out.println("(new)应得工资："+(fee1-sb-rt2));
	}

}
