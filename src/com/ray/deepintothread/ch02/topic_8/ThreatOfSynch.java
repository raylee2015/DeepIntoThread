package com.ray.deepintothread.ch02.topic_8;

/**
 * 从头认识多线程-2.6 同步方法的隐患<br>
 * http://blog.csdn.net/raylee2007/article/details/51279896<br>
 * 
 * @author RayLee
 *
 */
public class ThreatOfSynch {
	public static void main(String[] args) throws InterruptedException {
		MyService myService = new MyService();
		ThreadOne threadOne = new ThreadOne(myService);
		Thread thread = new Thread(threadOne);
		thread.start();
		ThreadTwo threadTwo = new ThreadTwo(myService);
		Thread thread2 = new Thread(threadTwo);
		thread2.start();

		Thread.sleep(10000);
		System.out.println("application use time:" + (MyTimeUtil.END_TIME - MyTimeUtil.START_TIME));
	}
}

class ThreadOne implements Runnable {

	private MyService myService;

	public ThreadOne(MyService myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.service();
	}
}

class ThreadTwo implements Runnable {

	private MyService myService;

	public ThreadTwo(MyService myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.service();
	}
}

class MyService {

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

	public synchronized void service() {
		long startTime = System.currentTimeMillis();
		if (MyTimeUtil.START_TIME == 0) {
			MyTimeUtil.START_TIME = startTime;
		}
		queryDataFromServer();
		updateDataFromServer();
		retrunDataFromServer();
		long endTime = System.currentTimeMillis();
		if (endTime > MyTimeUtil.END_TIME) {
			MyTimeUtil.END_TIME = endTime;
		}
		System.out.println("Thread name:" + Thread.currentThread().getName() + " user time:" + (endTime - startTime));
	}
}

class MyTimeUtil {
	public static long START_TIME = 0;
	public static long END_TIME = 0;
}
