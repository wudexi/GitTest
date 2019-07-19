package test;

public class ThreadSingletonTest {

	public static void main(String[] args) {
		final Counter counter = new Counter();
		for (int i = 0; i < 10000; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					synchronized(Counter.class){
						counter.inc();
					}
					
				}
			}).start();
		}

        System.out.println(counter);
		
	}

}
