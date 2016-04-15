package com.ray.deepintothread.ch01.topic_6;

public class InterruptWithExceptionSample2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadOne threadOne = new ThreadOne();
		threadOne.start();
	}
}

class ThreadOne extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i == 3) {
				System.out.println("���˳�");
				try {
					throw new RuntimeException();
				} catch (RuntimeException e) {
				}
			}

			System.out.println("interrupt:" + Thread.currentThread().isInterrupted());

			try {
				sleep(50);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("��������");
		super.run();

	}
}