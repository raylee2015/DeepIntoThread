package com.ray.deepintothread.ch01.topic_11;

public class SuspendMonopolize_3 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		ThreadTwo threadTwo = new ThreadTwo();
		Thread thread = new Thread(threadTwo);
		thread.start();
		Thread.sleep(50);
		thread.suspend();
		System.out.println("main end");
	}
}

class ThreadTwo implements Runnable {

	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		while (true) {
			count++;
			System.out.println(count);
		}
	}
}