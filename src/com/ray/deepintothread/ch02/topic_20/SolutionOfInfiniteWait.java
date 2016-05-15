package com.ray.deepintothread.ch02.topic_20;

/**
 * 
 * @author RayLee
 *
 */
public class SolutionOfInfiniteWait {
	public static void main(String[] args) throws InterruptedException {
		MyService2 myService = new MyService2();
		ThreadThree threadThree = new ThreadThree(myService);
		Thread thread = new Thread(threadThree);
		thread.start();
		ThreadFour threadFour = new ThreadFour(myService);
		Thread thread2 = new Thread(threadFour);
		thread2.start();
	}
}

class ThreadThree implements Runnable {
	private MyService2 myService;

	public ThreadThree(MyService2 myService) {
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

class ThreadFour implements Runnable {

	private MyService2 myService;

	public ThreadFour(MyService2 myService) {
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

class MyService2 {
	private static int id = 0;
	private static Object object1 = new Object();
	private static Object object2 = new Object();

	public void updateA() throws InterruptedException {
		synchronized (object1) {
			while (true) {
			}
		}
	}

	public synchronized void updateB() throws InterruptedException {
		synchronized (object2) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(100);
			}
		}
	}

}
