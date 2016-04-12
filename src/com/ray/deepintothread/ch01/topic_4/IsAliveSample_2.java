package com.ray.deepintothread.ch01.topic_4;

public class IsAliveSample_2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadSix threadSix = new ThreadSix();
		Thread thread = new Thread(threadSix);
		System.out.println("thread.isAlive():" + thread.isAlive());
		thread.start();
		System.out.println("thread.isAlive():" + thread.isAlive());
		Thread.sleep(1000);
		System.out.println("thread.isAlive():" + thread.isAlive());
	}
}

class ThreadSix extends Thread {

	@Override
	public void run() {
		super.run();
	}
}