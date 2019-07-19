package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.test.clone.Sudent;

public class FixedThreadPool {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		 final ExecutorService EXECUTOR = new ThreadPoolExecutor(2, 200,
																0L, TimeUnit.MILLISECONDS,
																new LinkedBlockingQueue<Runnable>(1024), 
																new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(),
																new ThreadPoolExecutor.AbortPolicy());
		
		 
			 Sudent s = new Sudent();
			 s.setName("张三");
			 s.setAge(11);
			 System.out.println("----------------step1-------------");
//		 	Future futrue =  EXECUTOR.submit(new Callable<Sudent>() {
//				@Override
//				public Sudent call() throws Exception {
//					s.setAge(33);
//					 System.out.println("----------------step2-------------");
//					return s;
//				}
//		 	});
		 	
		 	EXECUTOR.execute(new Thread(()->{
				 System.out.println("----------------step2-------------");
		 	}));

		 	System.out.println("----------------step3-------------");
		 	
		 	
		 	if(!EXECUTOR.isShutdown())
		 		EXECUTOR.shutdown();
		System.out.println(EXECUTOR.isShutdown());
//		System.out.println(futrue.get());
		System.out.println("----------------step4-------------");
		
	}

}
