package com.ray.deepintothread.ch01.topic_17;

public class DaemonSample {
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(1000);
		ThreadOne threadOne = new ThreadOne();
		threadOne.setDaemon(true);
		threadOne.start();
	}
}

class ThreadOne extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
	}
}
