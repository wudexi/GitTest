public class test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 90;
		int k = 2;
		System.out.print(num + "=");
		while (num > k) {
			if (num % k == 0) {
				System.out.print(k + "×");
				num = num / k;
			}
			if (num % k != 0) {
				k++;
			}
		}
		System.out.println(k);
	}
}
