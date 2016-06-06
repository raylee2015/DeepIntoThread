package com.ray.deepintothread.ch03.topic_2;

public class VolatileTest extends Thread {

	private volatile int id = 0;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread name :" + Thread.currentThread().getName() + " id :" + id++);
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileTest volatileTest1 = new VolatileTest();
		VolatileTest volatileTest2 = new VolatileTest();
		volatileTest1.start();
		Thread.sleep(100);
		volatileTest2.start();
	}
}
