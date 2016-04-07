package com.ray.deepintothread.ch01.topic_2;

public class NotShareTheVariables {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			RunnableTwo runnableTwo = new RunnableTwo();
			Thread thread = new Thread(runnableTwo);
			thread.start();
		}
	}
}

class RunnableTwo implements Runnable {

	private int count = 5;

	@Override
	public void run() {
		while (count > 0) {
			System.out.println("由线程" + Thread.currentThread().getName() + "计算 " + count--);
		}
	}
}