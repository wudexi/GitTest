package com.thread.demo.test;

/** 
 * 生产者线程，负责生产公共资源 
 */  
public class ProducerThread implements Runnable {  
    private PublicResource resource;  
  
    public ProducerThread(PublicResource resource) {  
        this.resource = resource;  
    }  
  
    @Override  
    public void run() {  
//        for (int i = 0; i < 50; i++) {  
//            try {  
//                Thread.sleep((long) (Math.random() * 500));  
//            } catch (InterruptedException e) {  
//                e.printStackTrace();  
//            }  
//        }  
        resource.increace();  
    }  
}