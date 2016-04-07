package com.ray.deepintothread.ch01.topic_2;

public class AnsychThread {
	public static void main(String[] args) {
			RunnableThree runnableThree = new RunnableThree();
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(runnableThree);
			thread.start();
		}
	}
}

class RunnableThree implements Runnable {

	private int count = 5;

	@Override
	public void run() {
		System.out.println("由线程" + Thread.currentThread().getName() + "计算 " + count--);
	}
}