package com.ray.deepintothread.ch01.topic_8;

public class CatchThreadDeath {
	public static void main(String[] args) throws InterruptedException {
		ThreadOne threadOne = new ThreadOne();
		threadOne.start();
		Thread.sleep(200);
	}
}

class ThreadOne extends Thread {

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		try {
			this.stop();
		} catch (ThreadDeath e) {
			System.out.println(e);
		}
		super.run();
	}
}