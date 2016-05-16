package com.ray.deepintothread.ch02.topic_21;

/**
 * 
 * @author RayLee
 *
 */
public class DeadLock {
	public static void main(String[] args) throws InterruptedException {
		MyService myService = new MyService();
		ThreadOne threadOne = new ThreadOne(myService);
		Thread thread = new Thread(threadOne);
		thread.start();
		ThreadTwo threadTwo = new ThreadTwo(myService);
		Thread thread2 = new Thread(threadTwo);
		thread2.start();
	}
}

class ThreadOne implements Runnable {
	private MyService myService;

	public ThreadOne(MyService myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		try {
			myService.updateA();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadTwo implements Runnable {

	private MyService myService;

	public ThreadTwo(MyService myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		try {
			myService.updateB();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyService {
	private Object object1 = new Object();
	private Object object2 = new Object();

	public void updateA() throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		synchronized (object1) {
			System.out.println("synch obj1");
			Thread.sleep(1000);
			synchronized (object2) {
				System.out.println("synch obj2");
			}
		}

	}

	public void updateB() throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		synchronized (object2) {
			System.out.println("synch obj2");
			Thread.sleep(1000);
			synchronized (object1) {
				System.out.println("synch obj1");
			}
		}
	}

}
