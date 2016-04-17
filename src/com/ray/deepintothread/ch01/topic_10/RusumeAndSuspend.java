package com.ray.deepintothread.ch01.topic_10;

public class RusumeAndSuspend {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		ThreadFive threadFive = new ThreadFive();
		Thread thread = new Thread(threadFive);
		thread.start();
		Thread.sleep(50);
		thread.suspend();
		System.out.println(System.currentTimeMillis() + " " + threadFive.getCount());
		Thread.sleep(50);
		System.out.println(System.currentTimeMillis() + " " + threadFive.getCount());
		Thread.sleep(50);
		thread.resume();
		System.out.println(System.currentTimeMillis() + " " + threadFive.getCount());
	}
}

class ThreadFive implements Runnable {

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
		}
	}
}