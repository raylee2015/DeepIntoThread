package com.ray.deepintothread.ch01.topic_1;

public class SimpleExtendThread2 {
	public static void main(String[] args) {
		ThreadOne2 threadOne = new ThreadOne2("Ïß³ÌA");
		Thread thread = new Thread(threadOne);
		System.out.println("start");
		thread.start();
	}
}

class ThreadOne2 extends Thread {

	private String name;

	public ThreadOne2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Thread " + name + " begin to run");
		super.run();
		System.out.println("Thread " + name + " end to run");
	}
}