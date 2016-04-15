package com.ray.deepintothread.ch01.topic_5;

public class InterruptSample {
	public static void main(String[] args) throws InterruptedException {
		ThreadFive threadFive = new ThreadFive();
		Thread thread = new Thread(threadFive);
		thread.start();
	}
}

class ThreadFive extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i == 3) {
				Thread.currentThread().interrupt();
			}
			System.out.println("interrupt:" + Thread.currentThread().isInterrupted());

			try {
				sleep(50);
			} catch (InterruptedException e) {
				System.out.println("catch interrupt:" + Thread.currentThread().isInterrupted());
			}
		}
		super.run();

	}
}