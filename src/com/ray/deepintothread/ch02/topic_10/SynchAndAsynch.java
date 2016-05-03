package com.ray.deepintothread.ch02.topic_10;

/**
 * 从头认识多线程-2.9 同步代码块的特殊现象：一半同步，一半异步<br>
 * http://blog.csdn.net/raylee2007/article/details/51296945<br>
 * 
 * @author RayLee
 *
 */
public class SynchAndAsynch {
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
		myService.update();
	}
}

class ThreadTwo implements Runnable {

	private MyService myService;

	public ThreadTwo(MyService myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.update();
	}
}

class MyService {

	private int a = 0;
	private int b = 0;
	private int c = 0;

	private void updateA() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread name:" + Thread.currentThread().getName() + " a:" + a++);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 增加同步
	 */
	private void updateB() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread name:" + Thread.currentThread().getName() + " b:" + b++);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateC() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread name:" + Thread.currentThread().getName() + " c:" + c++);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void update() {
		updateA();
		synchronized (this) {
			updateB();
		}
		updateC();
	}
}
