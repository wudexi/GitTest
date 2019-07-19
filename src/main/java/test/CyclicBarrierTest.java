package test;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
public class CyclicBarrierTest {
	static class Total implements Runnable{
		private CyclicBarrier cyclicBarrier;
		private int[] total;//全校总人数
		private int index;//哪个班
		public Total(CyclicBarrier cyclicBarrier, int[] total, int index) {
			this.cyclicBarrier = cyclicBarrier;
			this.total = total;
			this.index = index;
		}
		@Override
		public void run() {
			try {
				//统计某个班的人数
				total[index] = (int)(Math.random()*100);
				System.out.println("class "+index+" number:"+total[index]);
				cyclicBarrier.await();//等待其他班级的统计结果
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("----------");
		}
	}
	public static void main(String[] args) {
		final int size = 3;//全校班级
		final int[] allTotal = new int[size];//用数组存放每个班级的人数
		CyclicBarrier cyclicBarrier = new CyclicBarrier(size, new Runnable() {
			@Override
			public void run() {
				//统计全校总人数
				int n = 0;
				for(int i = 0; i < size; i++){
					 n += allTotal[i];
				}
				System.out.println(n);
			}
		});
		//派size个人去各个班统计人数
		for(int i = 0; i < size; i++){
			new Thread(new Total(cyclicBarrier, allTotal, i)).start();
		}

	}

}
