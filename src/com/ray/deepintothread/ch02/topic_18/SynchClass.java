package com.ray.deepintothread.ch02.topic_18;

/**
 * 
 * @author RayLee
 *
 */
public class SynchClass {
	public static void main(String[] args) throws InterruptedException {
		MyService myService = new MyService();
		ThreadOne threadOne = new ThreadOne();
		Thread thread = new Thread(threadOne);
		thread.start();
		ThreadTwo threadTwo = new ThreadTwo(myService);
		Thread thread2 = new Thread(threadTwo);
		thread2.start();
	}
}

class ThreadOne implements Runnable {

	@Override
	public void run() {
		try {
			MyService.updateA();
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
	private static int id = 0;

	public synchronized static void updateA() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + id++);
			Thread.sleep(50);
		}
	}

	public synchronized void updateB() throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + id++);
			Thread.sleep(100);
		}
	}

}
