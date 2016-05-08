package com.ray.deepintothread.ch02.topic_16;

/**
 * 
 * @author RayLee
 *
 */
public class DirtyReadWithSynchBlock {
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

	private Integer id = 0;

	public void updateA() throws InterruptedException {
		synchronized (id) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(50);
			}
		}
	}

	public void updateB() throws InterruptedException {
		synchronized (id) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(100);
			}
		}
	}

}
