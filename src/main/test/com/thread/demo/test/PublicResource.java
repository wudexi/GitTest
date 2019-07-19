package com.thread.demo.test;

/**
 * 公共资源类
 */
public class PublicResource {
	private int number = 0;

	/**
	 * 增加公共资源
	 */
	public synchronized void increace() {
		// while (number != 0) {
		// try {
		// wait();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		while (number >= 10) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		number++;
		System.out.println("增加公共资源:" + number);
		notify();
	}

	/**
	 * 减少公共资源
	 */
	public synchronized void decreace() {
		// while (number == 0) {
		// try {
		// wait();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }

		while (number == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		number--;
		System.out.println("减少公共资源:" + number);
		notify();
	}
}