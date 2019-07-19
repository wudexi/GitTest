package com.thread.demo.test;

public class ProducerConsumerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 	PublicResource resource = new PublicResource();  
		   for (int i = 0; i < 100000; i++) {
			   System.out.println("=============第"+(i+1)+"个Thread========");
//			    resource.increace();
			   new Thread(new ProducerThread(resource)).start();  
			   new Thread(new ConsumerThread(resource)).start();  
		   }
		 	
		 	
	        
//	        new Thread(new ProducerThread(resource)).start();  
//	        new Thread(new ConsumerThread(resource)).start();  
//	        
//	        new Thread(new ProducerThread(resource)).start();  
//	        new Thread(new ConsumerThread(resource)).start();  
	}

}
