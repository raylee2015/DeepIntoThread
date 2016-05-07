package com.ray.deepintothread.ch02.topic_14;

/**
 * 
 * @author RayLee
 *
 */
public class AsynchOfSynchWithUnSameObject {
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

	private Object object1;
	private Object object2;

	public MyService() {
		object1 = new Object();
		object2 = new Object();
	}

	public void updateA() throws InterruptedException {
		synchronized (object1) {
			long startTime = System.currentTimeMillis();
			System.out.println("updateA startTime:" + startTime);
			Thread.sleep(1000);
			long endTime = System.currentTimeMillis();
			System.out.println("updateA endTime:" + endTime);
		}
	}

	public void updateB() throws InterruptedException {
		synchronized (object2) {
			long startTime = System.currentTimeMillis();
			System.out.println("updateB startTime:" + startTime);
			Thread.sleep(1000);
			long endTime = System.currentTimeMillis();
			System.out.println("updateB endTime:" + endTime);
		}
	}

}
