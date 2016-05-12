package com.ray.deepintothread.ch02.topic_19;

/**
 * 
 * @author RayLee
 *
 */
public class MonitorOfSynch {
	public static void main(String[] args) throws InterruptedException {
		MyService myService = new MyService();
		ThreadOne threadOne = new ThreadOne(myService);
		Thread thread = new Thread(threadOne);
		thread.setName("thread A");
		thread.start();
		ThreadTwo threadTwo = new ThreadTwo(myService);
		Thread thread2 = new Thread(threadTwo);
		thread2.setName("thread B");
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

	private Integer id = 0;

	public void updateA() throws InterruptedException {
		synchronized (id) {
			for (int i = 0; i < 5; i++) {
				System.out.println("id:" + id);
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(50);
				System.out.println("-------------------");
			}
		}
	}

	public void updateB() throws InterruptedException {
		synchronized (id) {
			for (int i = 0; i < 5; i++) {
				System.out.println("id:" + id);
				System.out.println(Thread.currentThread().getName() + " " + id++);
				Thread.sleep(100);
				System.out.println("-------------------");
			}
		}
	}

}
