package com.ray.deepintothread.ch01.topic_1;

public class SimpleExtendThread {
	public static void main(String[] args) {
		ThreadOne threadOne = new ThreadOne();
		Thread thread = new Thread(threadOne);
		System.out.println("start");
		thread.start();
	}
}

class ThreadOne extends Thread {
	@Override
	public void run() {
		System.out.println("begin to run");
		super.run();
		System.out.println("end to run");
	}
}