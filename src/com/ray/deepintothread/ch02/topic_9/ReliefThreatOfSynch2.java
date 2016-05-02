package com.ray.deepintothread.ch02.topic_9;

/**
 * 从头认识多线程-2.8 缓解同步方法的隐患-同步代码块<br>
 * http://blog.csdn.net/raylee2007/article/details/51296811<br>
 * 
 * @author RayLee
 *
 */
public class ReliefThreatOfSynch2 {
	public static void main(String[] args) throws InterruptedException {
		MyService2 myService = new MyService2();
		ThreadThree threadThree = new ThreadThree(myService);
		Thread thread = new Thread(threadThree);
		thread.start();
		ThreadFour threadFour = new ThreadFour(myService);
		Thread thread2 = new Thread(threadFour);
		thread2.start();

		Thread.sleep(10000);
		System.out.println("application use time:" + (MyTimeUtil2.END_TIME - MyTimeUtil2.START_TIME));
	}
}

class ThreadThree implements Runnable {

	private MyService2 myService;

	public ThreadThree(MyService2 myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.service();
	}
}

class ThreadFour implements Runnable {

	private MyService2 myService;

	public ThreadFour(MyService2 myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.service();
	}
}

class MyService2 {

	private void queryDataFromServer() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void updateDataFromServer() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void retrunDataFromServer() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void service() {
		long startTime = System.currentTimeMillis();
		if (MyTimeUtil2.START_TIME == 0) {
			MyTimeUtil2.START_TIME = startTime;
		}
		queryDataFromServer();
		synchronized (this) {
			updateDataFromServer();
		}
		retrunDataFromServer();
		long endTime = System.currentTimeMillis();
		if (endTime > MyTimeUtil2.END_TIME) {
			MyTimeUtil2.END_TIME = endTime;
		}
		System.out.println("Thread name:" + Thread.currentThread().getName() + " user time:" + (endTime - startTime));
	}
}

class MyTimeUtil2 {
	public static long START_TIME = 0;
	public static long END_TIME = 0;
}
