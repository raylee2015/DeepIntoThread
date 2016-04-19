package com.ray.deepintothread.ch01.topic_15;

public class PrioritySample2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("before set , priority : " + Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		System.out.println("after set , priority : " + Thread.currentThread().getPriority());
		ThreadThree threadThree = new ThreadThree();
		Thread thread = new Thread(threadThree);
		thread.start();
	}
}

class ThreadThree implements Runnable {

	@Override
	public void run() {
		System.out.println("ThreadThree priority : " + Thread.currentThread().getPriority());
		ThreadFour threadFour = new ThreadFour();
		Thread thread = new Thread(threadFour);
		thread.start();
	}
}

class ThreadFour implements Runnable {

	@Override
	public void run() {
		System.out.println("ThreadFour priority : " + Thread.currentThread().getPriority());
	}
}
