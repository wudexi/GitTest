package test;

class Counter {
	
	private static int count = 0;
//	private  volatile  long count = 0;
	
	public  void inc() {
		count++;
	}
	@Override
	public String toString() {
		return "[count=" + count + "]";
	}
}
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        for (int i = 0; i < 100000; i++) {
          Thread t =  new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.inc();
//                    System.out.println(counter);
                }
            });
          t.start();
          t.join();

        }
        System.out.println(counter);
    }

    
}