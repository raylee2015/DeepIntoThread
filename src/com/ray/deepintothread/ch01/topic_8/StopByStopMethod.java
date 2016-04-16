package com.ray.deepintothread.ch01.topic_8;

public class StopByStopMethod {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		ThreadFive threadFive = new ThreadFive();
		threadFive.start();
		Thread.sleep(200);
		threadFive.stop();
	}
}

class ThreadFive extends Thread {

	@Override
	public void run() {
		System.out.println("------------begin-------------");
		try {
			System.out.println("------------working-------------");
			sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("------------exit-------------");
		}
		super.run();
	}
}