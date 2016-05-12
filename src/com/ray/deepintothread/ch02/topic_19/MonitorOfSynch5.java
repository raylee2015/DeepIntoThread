package com.ray.deepintothread.ch02.topic_19;

import java.util.ArrayList;

/**
 * 
 * @author RayLee
 *
 */
public class MonitorOfSynch5 {
	public static void main(String[] args) throws InterruptedException {
		MyService5 myService = new MyService5();
		ThreadNine threadNine = new ThreadNine(myService);
		Thread thread = new Thread(threadNine);
		thread.setName("thread A");
		thread.start();
		ThreadTen threadTen = new ThreadTen(myService);
		Thread thread2 = new Thread(threadTen);
		thread2.setName("thread B");
		thread2.start();
	}
}

class ThreadNine implements Runnable {

	private MyService5 myService;

	public ThreadNine(MyService5 myService) {
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

class ThreadTen implements Runnable {

	private MyService5 myService;

	public ThreadTen(MyService5 myService) {
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

class MyService5 {

	private ArrayList<Integer> list = new ArrayList<>();

	public void updateA() throws InterruptedException {
		synchronized (list) {
			for (int i = 0; i < 5; i++) {
				System.out.println("list size:" + list.size());
				list.add(i);
				System.out.println(Thread.currentThread().getName() + " " + list.size());
				Thread.sleep(50);
				System.out.println("-------------------");
			}
		}
	}

	public void updateB() throws InterruptedException {
		synchronized (list) {
			for (int i = 0; i < 5; i++) {
				System.out.println("list size:" + list.size());
				list.add(i);
				System.out.println(Thread.currentThread().getName() + " " + list.size());
				Thread.sleep(100);
				System.out.println("-------------------");
			}
		}
	}

}
