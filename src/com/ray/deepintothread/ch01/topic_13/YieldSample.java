package com.ray.deepintothread.ch01.topic_13;

public class YieldSample {
	public static void main(String[] args) throws InterruptedException {
		ThreadOne threadOne = new ThreadOne();
		Thread thread = new Thread(threadOne);
		thread.start();
	}
}

class ThreadOne implements Runnable {

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			Thread.yield();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
