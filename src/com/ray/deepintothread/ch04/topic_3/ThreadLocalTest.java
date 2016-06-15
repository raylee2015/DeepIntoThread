package com.ray.deepintothread.ch04.topic_3;

public class ThreadLocalTest extends Thread {

	private int count = 0;

	public ThreadLocal<Integer> intThreadLocal = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return count;
		};
	};

	public int getCount() {
		return intThreadLocal.get();
	}

	public void addCount() {
		intThreadLocal.set(count++);
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 3; i++) {
				addCount();
				System.out.println("Thread[" + getName() + "] count[" + getCount() + "]");
				sleep(50);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ThreadLocalTest().start();
		Thread.sleep(100);
		new ThreadLocalTest().start();
		Thread.sleep(100);
		new ThreadLocalTest().start();
	}
}
