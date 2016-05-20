package com.ray.deepintothread.ch02.topic_24;

/**
 * 
 * @author RayLee
 *
 */
public class SynchOfStaticInnerClass3 {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				MyService3.updateA();
			}
		});
		thread.start();
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				MyService3.updateB();
			}
		});
		thread2.start();
	}
}

class MyService3 {

	private static int a = 0;

	private static Object lock = new Object();

	public static void updateA() {
		synchronized (lock) {
			for (int i = 0; i < 10; i++) {
				if (i == 5) {// 把对监视器的修改延时了
					lock = new Object();
				}
				System.out.println("Thread name:" + Thread.currentThread().getName() + " a:" + a++);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void updateB() {
		synchronized (lock) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Thread name:" + Thread.currentThread().getName() + " a:" + a++);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
