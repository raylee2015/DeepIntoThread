package com.ray.deepintothread.ch02.topic_22;

/**
 * 
 * @author RayLee
 *
 */
public class SynchOfInnerClass3 {
	class InnerClass {
		private int id = 0;
		private Object object = new Object();

		public void service_1() throws InterruptedException {
			synchronized (object) {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName() + " id:" + id++);
					Thread.sleep(50);
				}
			}
		}

		public synchronized void service_2() throws InterruptedException {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " id:" + id++);
				Thread.sleep(100);
			}
		}
	}

	public InnerClass getInnerClass() {
		return new InnerClass();
	}

	public static void main(String[] args) {
		SynchOfInnerClass3 synchOfInnerClass = new SynchOfInnerClass3();
		InnerClass innerClass = synchOfInnerClass.getInnerClass();
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					innerClass.service_1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				try {
					innerClass.service_2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread2.start();
	}
}
