package com.ray.deepintothread.ch01.topic_15;

public class PrioritySample {
	public static void main(String[] args) throws InterruptedException {
		ThreadOne threadOne = new ThreadOne();
		Thread thread = new Thread(threadOne);
		System.out.println("before set , priority : " + Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		System.out.println("after set , priority : " + Thread.currentThread().getPriority());
		thread.start();
	}
}

class ThreadOne implements Runnable {

	@Override
	public void run() {
		System.out.println("ThreadOne priority : " + Thread.currentThread().getPriority());
		ThreadTwo threadTwo = new ThreadTwo();
		Thread thread = new Thread(threadTwo);
		thread.start();
	}
}

class ThreadTwo implements Runnable {

	@Override
	public void run() {
		System.out.println("ThreadTwo priority : " + Thread.currentThread().getPriority());
	}
}
