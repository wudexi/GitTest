package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Singleton{
	private Singleton(){}
	private static volatile Singleton single = null ;
	public static Singleton getInstance() {
		if(single == null){
			synchronized(Singleton.class){
				if(single == null){
					single = new Singleton();
				}
			}
		}
		return single;
	}

}
public class SingletonTest {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		for (int i = 0; i < 10; i++) {
//			executorService.execute(new Thread() {
//				public void run() {
//					super.run();
//					System.out.println(getId());
//					Singleton.getInstance();
//				}
//			});
			
			new Thread(){
				public void run() {
					super.run();
					System.out.println(this.getName());
					Singleton.getInstance();
				}
			}.start();
			
			
		}
	}

}
