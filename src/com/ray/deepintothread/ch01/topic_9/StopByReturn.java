package com.ray.deepintothread.ch01.topic_9;

public class StopByReturn {
	public static void main(String[] args) throws InterruptedException {
		ThreadFive threadFive = new ThreadFive();
		Thread thread1 = new Thread(threadFive);
		thread1.start();
		Thread thread2 = new Thread(threadFive);
		thread2.start();
		Thread.sleep(200);
		return;
	}
}

class ThreadFive implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " begin");
		try {
			System.out.println(Thread.currentThread().getName() + " working");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " exit");
		}
	}
}