package com.ray.deepintothread.ch02.topic_23;

/**
 * 
 * @author RayLee
 *
 */
public class SynchOfStaticInnerClass2 {
	static class InnerClass {
		private static int id = 0;
		private static Object object = new Object();

		public static void service_1() throws InterruptedException {
			synchronized (object) {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName() + " id:" + id++);
					Thread.sleep(50);
				}
			}
		}

		public static void service_2() throws InterruptedException {
			synchronized (object) {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName() + " id:" + id++);
					Thread.sleep(100);
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					InnerClass.service_1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				try {
					InnerClass.service_2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread2.start();
	}
}
