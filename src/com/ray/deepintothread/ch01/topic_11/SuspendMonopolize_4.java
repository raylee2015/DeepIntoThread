package com.ray.deepintothread.ch01.topic_11;

public class SuspendMonopolize_4 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		ThreadThree threadThree = new ThreadThree();
		Thread thread = new Thread(threadThree);
		thread.start();
		Thread.sleep(50);
		thread.suspend();
		thread.stop();
		System.out.println("main end");
	}
}

class ThreadThree implements Runnable {

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