package com.ray.deepintothread.ch02.topic_11;

/**
 * 
 * @author RayLee
 *
 */
public class ObjectLock {
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

	public void updateA() throws InterruptedException {
		synchronized (this) {
			long startTime = System.currentTimeMillis();
			System.out.println("updateA startTime:" + startTime);
			Thread.sleep(1000);
			long endTime = System.currentTimeMillis();
			System.out.println("updateA endTime:" + endTime);
		}
	}

	public void updateB() throws InterruptedException {
		synchronized (this) {
			long startTime = System.currentTimeMillis();
			System.out.println("updateB startTime:" + startTime);
			Thread.sleep(1000);
			long endTime = System.currentTimeMillis();
			System.out.println("updateB endTime:" + endTime);
		}
	}

}
