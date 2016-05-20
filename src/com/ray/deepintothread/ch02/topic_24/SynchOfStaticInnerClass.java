package com.ray.deepintothread.ch02.topic_24;

/**
 * 
 * @author RayLee
 *
 */
public class SynchOfStaticInnerClass {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				MyService.updateA();
			}
		});
		thread.start();
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				MyService.updateB();
			}
		});
		thread2.start();
	}
}

class MyService {

	private static int id = 0;

	private static String lock = "a";

	public static void updateA() {
		synchronized (lock) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Thread name:" + Thread.currentThread().getName() + " id:" + id++);
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
				System.out.println("Thread name:" + Thread.currentThread().getName() + " id:" + id++);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
