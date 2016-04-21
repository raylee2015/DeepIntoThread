package com.ray.deepintothread.ch02.topic_1;

public class ThreadSafeOfInstanceVariable {
	public static void main(String[] args) throws InterruptedException {
		ThreadTow threadTow = new ThreadTow();
		Thread thread = new Thread(threadTow);
		Thread thread1 = new Thread(threadTow);
		thread.start();
		thread1.start();
	}
}

class ThreadTow implements Runnable {
	private int count = 0;

	private synchronized void test() {
		for (int i = 0; i < 5; i++) {
			System.out.println(count++);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		test();
	}
}
