package com.ray.deepintothread.ch02.topic_24;

/**
 * 
 * @author RayLee
 *
 */
public class SynchOfStaticInnerClass5 {

	public static void main(String[] args) {
		MyService5 myService5 = new MyService5();
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					myService5.updateA();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				myService5.updateB();
			}
		});
		thread2.start();
	}
}

class MyService5 {

	private static int a = 0;

	private static Monitor lock;

	public MyService5() {
		lock = new Monitor();
		lock.id = 1;
	}

	public void updateA() throws InterruptedException {
		synchronized (lock) {
			lock.id = 2;// 修改对象的属性
			Thread.sleep(300);
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

	public void updateB() {
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

class Monitor {
	public int id = 0;
}
