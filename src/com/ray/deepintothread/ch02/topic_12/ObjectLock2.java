package com.ray.deepintothread.ch02.topic_12;

/**
 * 
 * @author RayLee
 *
 */
public class ObjectLock2 {
	public static void main(String[] args) throws InterruptedException {
		MyService2 myService2 = new MyService2();
		ThreadThree threadThree = new ThreadThree(myService2);
		Thread thread = new Thread(threadThree);
		thread.start();
		ThreadFour threadFour = new ThreadFour(myService2);
		Thread thread2 = new Thread(threadFour);
		thread2.start();
	}
}

class ThreadThree implements Runnable {

	private MyService2 myService2;

	public ThreadThree(MyService2 myService2) {
		this.myService2 = myService2;
	}

	@Override
	public void run() {
		try {
			myService2.updateA();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadFour implements Runnable {

	private MyService2 myService2;

	public ThreadFour(MyService2 myService2) {
		this.myService2 = myService2;
	}

	@Override
	public void run() {
		try {
			myService2.updateB();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyService2 {
	private int count = 0;

	public synchronized void updateA() throws InterruptedException {
		System.out.println(this);
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread name:" + Thread.currentThread().getName() + " count:" + count++);
			Thread.sleep(50);
		}
	}

	public synchronized void updateB() throws InterruptedException {
		System.out.println(this);
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread name:" + Thread.currentThread().getName() + " count:" + count++);
			Thread.sleep(100);
		}
	}

}
