package com.ray.deepintothread.ch01.topic_9;

public class StopByReturn2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadOne threadOne = new ThreadOne();
		threadOne.start();
		Thread.sleep(200);
		threadOne.interrupt();
	}
}

class ThreadOne extends Thread {

	@Override
	public void run() {
		while (true) {
			if (this.isInterrupted()) {
				System.out.println("return");
				return;
			}
		}
	}
}