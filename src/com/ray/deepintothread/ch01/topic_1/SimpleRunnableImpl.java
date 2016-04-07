package com.ray.deepintothread.ch01.topic_1;

public class SimpleRunnableImpl {
	public static void main(String[] args) {
		RunnableOne threadOne = new RunnableOne();
		Thread thread = new Thread(threadOne);
		System.out.println("start");
		thread.start();
	}
}

class RunnableOne implements Runnable {

	@Override
	public void run() {
		System.out.println("begin to run");
	}
}