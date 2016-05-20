package com.ray.deepintothread.ch02.topic_24;

/**
 * 
 * @author RayLee
 *
 */
public class SynchOfStaticInnerClass4 {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					MyService4.updateA();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				MyService4.updateB();
			}
		});
		thread2.start();
	}
}

class MyService4 {

	private static int a = 0;

	private static Object lock = new Object();

	public static void updateA() throws InterruptedException {
		synchronized (lock) {
			Thread.sleep(300);//把对监视器的修改延时了
			lock = new Object();
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
