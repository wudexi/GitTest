package test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {
	 static  LongAdder longAdder = new LongAdder();
//	private static AtomicLong ai = new AtomicLong(0);
	
	static class MyThread implements Runnable {
		@Override
		public void run() {
//        	longAdder.increment();
//        	longAdder.add(2);
//			ai.incrementAndGet();
        	 for (int i = 0; i < 100000; i++) {
        		 longAdder.increment();
             }
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyThread my = new MyThread();
		long time = System.currentTimeMillis();
//		System.out.println("毫秒"+System.currentTimeMillis());
		for (int i = 0; i < 100; i++) {
			Thread t1 = new Thread(my);
			t1.start();
//			t1.join();
			Thread.sleep(10);
//			Thread.sleep(3);
		}
		System.out.println(longAdder.longValue());
		System.out.println("毫秒"+(System.currentTimeMillis()-time)/1000d);
//		System.out.println(longAdder.sum());
		
//		 	Thread t1 = new Thread(new MyThread());
//	        Thread t2 = new Thread(new MyThread());
//	        t1.start();
//	        t2.start();
//	        t1.join();
//	        t2.join();
//	       System.out.println(longAdder.intValue() == 200000);
//	       System.out.println(longAdder.longValue());
		
		
	}


}
