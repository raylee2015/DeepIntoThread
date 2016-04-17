package com.ray.deepintothread.ch01.topic_11;

public class SuspendMonopolize_1 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		ThreadFive threadFive = new ThreadFive();
		Thread thread = new Thread(threadFive);
		thread.start();
		Thread.sleep(50);
		thread.suspend();
		Thread.sleep(50);
		thread.resume();
		return;
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
			System.out.println(count++);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}