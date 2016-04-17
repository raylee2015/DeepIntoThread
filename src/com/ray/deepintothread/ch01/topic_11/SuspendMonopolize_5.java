package com.ray.deepintothread.ch01.topic_11;

public class SuspendMonopolize_5 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		ThreadFour threadFour = new ThreadFour();
		Thread thread = new Thread(threadFour);
		thread.start();
		Thread.sleep(50);
		thread.suspend();
		throw new RuntimeException();
	}
}

class ThreadFour implements Runnable {

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