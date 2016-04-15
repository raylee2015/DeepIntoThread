package com.ray.deepintothread.ch01.topic_6;

public class FakeInterruptSample {
	public static void main(String[] args) throws InterruptedException {
		ThreadFive threadFive = new ThreadFive();
		threadFive.start();
		threadFive.interrupt();
	}
}

class ThreadFive extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (Thread.interrupted()) {
				System.out.println("�˳�ѭ��");
				break;
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