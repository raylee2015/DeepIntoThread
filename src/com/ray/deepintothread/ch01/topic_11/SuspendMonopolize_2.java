package com.ray.deepintothread.ch01.topic_11;

public class SuspendMonopolize_2 {
	public static void main(String[] args) throws InterruptedException {
		Test test = new Test();
		ThreadOne threadOne = new ThreadOne(test);
		Thread thread = new Thread(threadOne);
		thread.start();
		Thread.sleep(50);
		Thread thread2 = new Thread(threadOne);
		thread2.start();
	}
}

class Test {
	@SuppressWarnings("deprecation")
	public synchronized void printStr() {
		System.out.println(Thread.currentThread().getName() + " begin");
		Thread.currentThread().suspend();
		System.out.println(Thread.currentThread().getName() + " end");
	}
}

class ThreadOne implements Runnable {

	private Test test;

	public ThreadOne(Test test) {
		this.test = test;
	}

	@Override
	public void run() {
		test.printStr();
	}
}