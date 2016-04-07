package com.ray.deepintothread.ch01.topic_2;

public class SychThreadWithTag {
	public static void main(String[] args) {
		RunnableFour runnableFour = new RunnableFour();
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(runnableFour);
			thread.start();
		}
	}
}

class RunnableFour implements Runnable {

	private int count = 5;

	@Override
	public synchronized void run() {
		System.out.println("由线程" + Thread.currentThread().getName() + "计算 " + count--);
	}
}