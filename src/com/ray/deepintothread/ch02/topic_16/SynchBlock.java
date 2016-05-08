package com.ray.deepintothread.ch02.topic_16;

/**
 * 
 * @author RayLee
 *
 */
public class SynchBlock {
	public static void main(String[] args) throws InterruptedException {
		MyService myService = new MyService();
		int id = 1;
		ThreadOne threadOne = new ThreadOne(myService, id);
		Thread thread = new Thread(threadOne);
		thread.start();
		ThreadTwo threadTwo = new ThreadTwo(myService, id);
		Thread thread2 = new Thread(threadTwo);
		thread2.start();
	}
}

class ThreadOne implements Runnable {

	private MyService myService;

	private int id = 0;

	public ThreadOne(MyService myService, int id) {
		this.myService = myService;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			myService.updateA(id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadTwo implements Runnable {

	private MyService myService;

	private int id = 0;

	public ThreadTwo(MyService myService, int id) {
		this.myService = myService;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			myService.updateB(id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyService {
	public void updateA(Integer id) throws InterruptedException {
		synchronized (id) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(50);
			}
		}
	}

	public void updateB(Integer id) throws InterruptedException {
		synchronized (id) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(100);
			}
		}
	}

}
