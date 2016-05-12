package com.ray.deepintothread.ch02.topic_19;

import java.util.Date;

/**
 * 
 * @author RayLee
 *
 */
public class MonitorOfSynch4 {
	public static void main(String[] args) throws InterruptedException {
		MyService4 myService = new MyService4();
		ThreadSeven threadSeven = new ThreadSeven(myService);
		Thread thread = new Thread(threadSeven);
		thread.setName("thread A");
		thread.start();
		ThreadEight threadEight = new ThreadEight(myService);
		Thread thread2 = new Thread(threadEight);
		thread2.setName("thread B");
		thread2.start();
	}
}

class ThreadSeven implements Runnable {

	private MyService4 myService;

	public ThreadSeven(MyService4 myService) {
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

class ThreadEight implements Runnable {

	private MyService4 myService;

	public ThreadEight(MyService4 myService) {
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

class MyService4 {

	private Date date = new Date();

	public void updateA() throws InterruptedException {
		synchronized (date) {
			for (int i = 0; i < 5; i++) {
				System.out.println("date:" + date.toString());
				date = new Date();
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " " + date.toString());
				Thread.sleep(500);
				System.out.println("-------------------");
			}
		}
	}

	public void updateB() throws InterruptedException {
		synchronized (date) {
			for (int i = 0; i < 5; i++) {
				System.out.println("date:" + date.toString());
				date = new Date();
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " " + date.toString());
				Thread.sleep(1000);
				System.out.println("-------------------");
			}
		}
	}

}
