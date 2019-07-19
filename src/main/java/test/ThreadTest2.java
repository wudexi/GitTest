package test;


public class ThreadTest2 {
	
	public  void say() {
		for (int i = 0; i < 100; i++) {
			new Thread(new ThreadDome(i)).start();
		}
	}
	class ThreadDome implements Runnable{
		private int num;
		public ThreadDome(int num) {
			this.num = num;
		}
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				num++;
			}
			System.out.println("线程 "+Thread.currentThread().getName()+":"+num);
		}
	}
	public static void main(String[] args) {
		new ThreadTest2().say();
	}

}
