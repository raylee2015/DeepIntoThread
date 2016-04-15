package com.ray.deepintothread.ch01.topic_6;

public class InterruptWithExceptionSample {
	public static void main(String[] args) throws InterruptedException {
		ThreadSix threadSix = new ThreadSix();
		threadSix.start();
	}
}

class ThreadSix extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i == 3) {
				System.out.println("退出线程");
				throw new RuntimeException();
			}

			System.out.println("interrupt:" + Thread.currentThread().isInterrupted());

			try {
				sleep(50);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("测试数据");
		super.run();

	}
}