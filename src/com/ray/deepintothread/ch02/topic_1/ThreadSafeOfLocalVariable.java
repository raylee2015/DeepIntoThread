package com.ray.deepintothread.ch02.topic_1;

public class ThreadSafeOfLocalVariable {
	public static void main(String[] args) throws InterruptedException {
		ThreadOne threadOne = new ThreadOne();
		Thread thread = new Thread(threadOne);
		Thread thread1 = new Thread(threadOne);
		thread.start();
		thread1.start();
	}
}

class ThreadOne implements Runnable {

	@Override
	public void run() {
		int count = 0;
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
