package com.ray.deepintothread.ch01.topic_14;

public class PrioritySample {
	public static void main(String[] args) throws InterruptedException {
		ThreadOne threadOne = new ThreadOne();
		Thread thread = new Thread(threadOne);
		thread.setPriority(5);
		Thread thread1 = new Thread(threadOne);
		thread1.setPriority(4);

		thread1.start();
		thread.start();
	}
}

class ThreadOne implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getPriority());
	}
}
