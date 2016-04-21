package com.ray.deepintothread.ch02.topic_1;

public class ThreadUnSafeOfInstanceVariable {
	public static void main(String[] args) throws InterruptedException {
		ThreadFour threadFour = new ThreadFour();
		Thread thread = new Thread(threadFour);
		Thread thread1 = new Thread(threadFour);
		thread.start();
		thread1.start();
	}
}

class ThreadFour implements Runnable {
	private int count = 0;

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(count++);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
