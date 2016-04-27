package com.ray.deepintothread.ch02.topic_5;

public class ReGetInTheLock2 {
	public static void main(String[] args) throws InterruptedException {
		Sub sub = new Sub();
		ThreadTwo threadTwo = new ThreadTwo(sub);
		Thread thread = new Thread(threadTwo);
		thread.start();
	}
}

class ThreadTwo implements Runnable {

	private Sub sub;

	public ThreadTwo(Sub sub) {
		this.sub = sub;
	}

	@Override
	public void run() {
		sub.show();
	}
}

class Father {
	public void show() {
		System.out.println("father show");
	}
}

class Sub extends Father {
	@Override
	public void show() {
		System.out.println("sub show");
		super.show();
	}
}